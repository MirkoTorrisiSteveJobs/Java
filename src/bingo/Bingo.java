package bingo;

import java.util.ArrayList;
import java.util.Random;

public class Bingo {
    public ArrayList<Integer> board;
    public ArrayList<BingoCard> players = new ArrayList<BingoCard>();
    private boolean cinquina;
    public boolean bingo;
    private boolean justOnce = false;
    private int number;
    private int maxCount = 0;
    private BingoCard playerCinquina;

    public Bingo(int numOfPlayers) {
        this.board = generateBoard();
        for(int i =1; i <= numOfPlayers; i++){
            String name = "player "+i;
            players.add(new BingoCard(name));
        }
    }
    private ArrayList<Integer> generateBoard(){
        ArrayList<Integer> board = new ArrayList<Integer>();
        board.add(1);
        for(int i = 1; i <= 90; i ++){
            board.add(i);
        }
        board.remove(0);
        return board;
    }
    private int drawingByLot(){
        Random rand = new Random();
        return board.remove(rand.nextInt(board.size()));
        }
    private boolean checkNumbers(BingoCard card, int extractNumber){
        for(int[]rows:card.getCard()){
            for(int number:rows){
                if(number == extractNumber){
                    card.countPoints++;
                    return true;
                }
            }
        }
        return false;
    }
    private void checkCinquina(BingoCard player){
        for(int[]rows:player.getCard()){
            int count = 0;
            for(int number: rows){
                if(number == 99){
                    count++;
                }
                if(count == 5){
                    cinquina = true;
                    playerCinquina = player;
                }
            }
        }
    }
    private void checkBingo(BingoCard player){
      if (player.countPoints == 15){
          bingo = true;
          System.out.println(player.name + "\u001B[33mWON\u001B[0m");
        };
    }
    public void playBingo(){
        number = drawingByLot();
        for(BingoCard player:players){
            if(checkNumbers(player, number)){
                player.setNumber(number);
                if(!cinquina){
                    checkCinquina(player);
                }
                else{
                    checkBingo(player);
                }
            }
        }
    }

    @Override
    public String toString() {
        String result = "Lucky number is : \u001B[36m"+ number+"\u001B[0m";
        for(BingoCard player:players){
            if(player.countPoints >= maxCount) {
                maxCount = player.countPoints;
                result += player.toString();
            }
        }
        if(cinquina){
            if(!justOnce) {
                result+= playerCinquina.toString();
                result += "\n\u001B[33m^^^^^^^^^^^^\n!!!!!!!!!CINQUINA!!!!!\u001b[0m";

                justOnce = true;
            }
        }
        if(bingo){
            result += "\n\u001B[34m!!!!BINGO!!!!!\u001B[0m";
        }
        return result;
    }
}
