package bingo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BingoCard {
    private int [][] card;
    public String name;
    public int countPoints;
    public BingoCard(String name) {
        this.card = new int[3][9];
        this.name = name;
        generateCard();
    }
        private void generateCard(){
            int count = 0;
            Random rand = new Random();
            for(int i = 0; i<9; i++) {
                switch (rand.nextInt(3)) {
                    case 0:
                        this.card[0][i] = 0;
                        this.card[1][i] = rand.nextInt(10)+1+i*10;
                        count++;
                        this.card[2][i] = 0;
                        break;
                    case 1:
                        this.card[0][i] = rand.nextInt(10 -5)+1+i*10;
                        count++;
                        this.card[1][i] = 0;
                        this.card[2][i] = rand.nextInt(10 -5)+6+i*10;
                        count++;
                        break;
                    case 2:
                        this.card[0][i] = rand.nextInt(10 -7)+1+i*10;
                        count++;
                        this.card[1][i] = rand.nextInt(10 -7)+4+i*10;
                        count++;
                        this.card[2][i] = rand.nextInt(10 -7)+8+i*10;
                        count++;
                        break;
                }
            }
            if (count != 15){
                generateCard();
        }
    }

    @Override
    public String toString() {
        String result = "\n------"+name+"------\n";
        for(int i = 0; i < card.length; i++){
            result+="\n";
            for (int x = 0 ; x < card[i].length; x++){
                if(card[i][x] < 10 &&  card[i][x] !=0) {
                    result += "|\u001B[34m0" + card[i][x]+"\u001B[0m";
                }
                else if(card[i][x] == 0){
                    result += "|__";
                }
                else if(card[i][x] == 99){
                    result += "|\u001B[31m" + card[i][x]+"\u001B[0m";
                }
                else{
                    result += "|\u001B[34m" + card[i][x]+"\u001B[0m";
                }

            }
        }
        return result;
    }

    public int[][] getCard() {
        return card;
    }
    public void setNumber(int extractNumber) {
        for (int i = 0; i < card.length; i++) {
            for (int n = 0; n <card[i].length; n++) {
                if (card[i][n] == extractNumber) {
                    card[i][n] = 99;
                }
            }
        }
    }
}
