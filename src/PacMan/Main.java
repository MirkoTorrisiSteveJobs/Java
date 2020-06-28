package PacMan;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        PacManGame game = new PacManGame();
        Scanner scanner = new Scanner(System.in);
        System.out.println(game.toString());

        while (!game.gameOver){
            int dir = Integer.parseInt(scanner.nextLine());
            game.getPlayer().setDirection(dir);
            game.gamePlay();
            System.out.println(game.toString());
        }
        System.out.println("GAMOVER");
    }
}
