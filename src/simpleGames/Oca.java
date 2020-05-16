package simpleGames;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Oca {
    private char pedina = 'x';
    private char[] board = {pedina,'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'};
    private char pedina2 = 'y';
    private char[] board2 = {pedina2,'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'};
    private boolean over = false;
    private int rollDice(){
        return new Random().nextInt(5) + 1;
    }
    private int indexOf(char[]board, char pedina){
        int result = -1;
        for(int i=0; i<board.length;i++){
            if(board[i] == pedina){
                result = i;
            }
        }
        return result;
    }
    private void printBoard(char []board){
        for(int i = 0; i < board.length; i++){
            System.out.print("[ "+board[i]+ " ]");
        }
    }
    public void game(){
        while(!over){
            play1();
            play2();
        }
        board[0] = pedina;
        board2[0] = pedina2;
    }
    private void play1(){
            //Scanner roll = new Scanner(System.in);
            //System.out.println("Roll the dice: (any key) ");
            //roll.next();
            printBoard(board);

            int dice = rollDice();
            int position = indexOf(board, pedina);
            System.out.println("risultato del dado 1 : "+dice);
            board[position] = 'O';
            position += dice;
            if(position < board.length-1){
                board[position] = pedina;
            }
            else if(position == board.length-1){
                System.out.println("Ha vinto il giocatore 1");
                over = true;
            }
            else{
                board[board.length-(position-board.length)-2] = pedina;
            }
        }

    private void play2(){
            //Scanner roll = new Scanner(System.in);
            //System.out.println("Roll the dice: (any key) ");
            //roll.next();
            printBoard(board2);

            int dice = rollDice();
            int position = indexOf(board2, pedina2);
            System.out.println("risultato del dado 2: "+dice);
            board2[position] = 'O';
            position += dice;
            if(position < board2.length-1){
                board2[position] = pedina2;
            }
            else if(position == board2.length-1){
                System.out.println("Ha vinto il giocatore 2");
                over = true;
            }
            else{
                board2[board2.length-(position-board2.length)-2] = pedina2;
            }
        }
    }

