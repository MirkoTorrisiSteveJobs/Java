package bingo;

import java.util.ArrayList;
import java.util.Random;

public class Bingo {
    public ArrayList<Integer> board;
    public ArrayList<BingoCard> players = new ArrayList<BingoCard>();
    private boolean cinquina;
    public boolean bingo;
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
        int number = rand.nextInt(board.size());
        int choosen = board.get(number);
        board.remove(number);
        return choosen;
        }
    private boolean checkNumbers(BingoCard card, int extractNumber){
        for(int i = 0; i < card.getCard().length; i ++){
            for(int number:card.getCard()[i]){
                if(number == extractNumber){
                    return true;
                }
            }
        }
        return false;
    }
    private void checkCinquina(BingoCard player){
        for(int i = 0; i < player.getCard().length; i ++){
            int count = 0;
            for(int number: player.getCard()[i]){
                if(number == 99){
                    count++;
                }
                if(count == 5){
                    cinquina = true;
                }
            }
        }
    }
    private void checkBingo(BingoCard player){
        int count = 0;
        for(int i = 0; i < player.getCard().length; i ++){
            for(int number: player.getCard()[i]){
                if(number == 99){
                    count++;
                }

            }
            if(count == 15){
                bingo = true;
            }
        }
    }
    public void playBingo(){
        int number = drawingByLot();
        System.out.println("Lucky number is : "+ number);
        for(BingoCard player:players){
            if(checkNumbers(player, number)){
                System.out.println(player.name+" got it");
                player.setNumber(number);
                if(!cinquina){
                    checkCinquina(player);
                    if(cinquina){
                        System.out.println("CINQUINAAAAAAA");
                    }
                }
                else{
                    checkBingo(player);
                    if(bingo){
                        System.out.println("BINGOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        for(BingoCard player:players){
            result+=player.toString();
        }
        return result;
    }
}
