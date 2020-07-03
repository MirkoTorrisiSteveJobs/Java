package CardGames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    private int numOfCard;
    private  int sizeHand;
    private ArrayList<Card> discarded = new ArrayList<Card>();
    private Stack<Card> cards = new Stack<Card>();
    public Deck(int numOfCard){
        this.numOfCard = numOfCard;
    }
    public void addCard(String file){
        ArrayList<String[]> data = CSV.read(file);
            for (String[] row : data) {
               this.cards.push(new Card(row[0], Integer.parseInt(row[1])));
            }
    }
    public void setSizeHand(int sizeHand){
        this.sizeHand = sizeHand;
    }
    public ArrayList<Card> getDiscarded(){
        return this.discarded;
    }
    public void initDiscarded(){
        for (int i = 0; i < this.sizeHand; i++) {
            this.discarded.add(this.cards.pop());
        }

    }
    public void discardCard(){
        this.discarded.add(this.cards.pop());
    }
    public Card drawCard(){
        return this.cards.pop();
    }
    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public Stack<Card> getCard() {
        return this.cards;
    }
    public int getNumOfCard() {
        return numOfCard;
    }
}
