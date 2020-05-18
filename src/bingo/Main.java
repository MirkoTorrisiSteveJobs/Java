package bingo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Bingo bingo = new Bingo(500);
        Scanner scan = new Scanner(System.in);
        System.out.println("---WELCOME TO BINGO---");
        while(!bingo.bingo){
        bingo.playBingo();

        System.out.println(bingo.toString());
        System.out.println("Do something to get another number");
        scan.nextLine();
        }
    }
}
