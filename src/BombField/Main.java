package BombField;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Field field;
        System.out.println("select difficult level: \n1 (9x9) \n2(16x16) \n3(30x30)");
        int choice = Integer.parseInt(scan.nextLine());
        if(choice == 1){
            field = new Field(9);
        }
        else if(choice == 2){
            field = new Field(16);
        }
        else{
            field = new Field(30);
        }
        System.out.println(field.toString());
        while (!field.gameOver){
            System.out.println("X = ");
            int x = Integer.parseInt(scan.nextLine());
            System.out.println("Y = ");
            int y = Integer.parseInt(scan.nextLine());
            field.uncoverBox(x,y);
            System.out.println(field.toString());
            field.checkBomb(x,y);
            if(field.checkWin()){
                System.out.println("HAI VINTO!!!");
            }
        }
        field.showBombs();
        System.out.println(field.toString());
        System.out.println("GAME OVER");
    }
}
