package CardGames;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private int numOfCard;
    private int sizeHand;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private ArrayList<Card> cards = new ArrayList<Card>();
    public Deck(int numOfCard){
        this.numOfCard = numOfCard;
    }
    public void addCard(String file){
        ArrayList<String[]> data = CSV.read(file);
            for (String[] row : data) {
               this.cards.add(new Card(row[0], Integer.parseInt(row[1])));
            }
    }
    public void setSizeHand(int sizeHand){
        this.sizeHand = sizeHand;
    }
    public ArrayList<Card> getHand(){
        return this.hand;
    }
    public void initHand(){
        for (int i = 0; i < this.sizeHand; i++) {
            this.hand.add(this.cards.get(i));
        }
        for (int i = 0; i < this.sizeHand; i++) {
            this.cards.remove(i);
        }
    }
    public void draw(){
        this.hand.add(this.cards.get(0));
        this.cards.remove(0);
    }
    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public ArrayList<Card> getCard() {
        return this.cards;
    }
    public int getNumOfCard() {
        return numOfCard;
    }
}
