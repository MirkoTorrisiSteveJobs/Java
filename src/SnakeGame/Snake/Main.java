package SnakeGame.Snake;


import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        SnakeGame game = new SnakeGame(10,20);
        System.out.println(game.toString());
        game.getSnake().setDirection(6);
        game.snakePlay();
        System.out.println(game.toString());
        game.snakePlay();
        System.out.println(game.toString());
        game.snakePlay();
        System.out.println(game.toString());
        Scanner scan = new Scanner((System.in));
        while (!game.gameOver) {
            int dir = Integer.parseInt(scan.nextLine());
            game.getSnake().setDirection(dir);
            game.snakePlay();
            System.out.println(game.toString());
        }

    }
}
