package BattleShip;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int size = 6;
        BattleShip battle = new BattleShip(size);
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        System.out.println(battle.toString());
        int count = 1;
        while(count < 5){
            int[] arrayForShip = new int[2];
            System.out.println("insert start coordinats for ship with length"+(count)+"(it will extend right or down)");
            System.out.println("x: ");
            arrayForShip[0] = Integer.parseInt(scan.nextLine());
            System.out.println("y:");
            arrayForShip[1] = Integer.parseInt(scan.nextLine());
            System.out.println("choose if ship with length "+count+" must be horizontal(0) or vertical (everything else)");
            Ship ship = new Ship(count, arrayForShip, false);
            if(Integer.parseInt(scan.nextLine())== 0) {
                ship = new Ship(count, arrayForShip, true);
            }
            if(battle.checkIfShipisValid(ship.getCoordinates(),size)) {
                boolean ctrl = true;
                for (int[] arr : ship.getCoordinates()) {
                    if (battle.checkIfShipSCollide(battle.player, arr)) {
                        System.out.println("coordinate "+arr[0]+" "+arr[1]+" conflicts with an already placed ship");
                        ctrl = false;
                    }
                }
                if(ctrl){
                    System.out.println("ship "+count+" placed");
                    battle.player.loadShip(ship);
                    count++;
                }
            }
            else{
                System.out.println("Coordinates out of bounds");
            }
        }
        count = 1;
        while(count < 5){
            int[] arrayForShip = new int[2];
            for(int i = 0; i < count; i++){
                arrayForShip[0] = random.nextInt(size);
                arrayForShip[1] = random.nextInt(size);
            }
            Ship ship = new Ship(count, arrayForShip, false);
            if(random.nextInt(1) > 0){
                ship = new Ship(count, arrayForShip, true);
            }
            if(battle.checkIfShipisValid(ship.getCoordinates(),size)) {
                boolean ctrl = true;
                for (int[] arr : ship.getCoordinates()) {
                    if (battle.checkIfShipSCollide(battle.opp, arr)) {
                        ctrl = false;
                    }
                }
                if(ctrl){
                    System.out.println("enemy ship "+count+" placed");
                    battle.opp.loadShip(ship);
                    count++;
                }
            }
        }
        battle.loadShips();
        while(!(battle.youLose() && battle.youWin())){
            boolean hasShot = false;
            while(!hasShot) {
                System.out.println("insert attack coordinates: \n X = ");
                int x = Integer.parseInt(scan.nextLine());
                System.out.println("Y = ");
                int y = Integer.parseInt(scan.nextLine());
                if(!(hasShot = battle.shot(x,y,battle.player,battle.opp))){
                    System.out.println("You already bombed here");
                }
            }
            hasShot = false;
            while(!hasShot) {
                int x = random.nextInt(size);
                int y = random.nextInt(size);
                hasShot = battle.shot(x,y,battle.opp,battle.player);
            }
            battle.loadHits();
            System.out.println(battle.toString());
            if(battle.youWin()){
                System.out.println("You win");
                break;
            }
            if(battle.youLose()){
                System.out.println("You lose");
                break;
            }
        }
    }
}
