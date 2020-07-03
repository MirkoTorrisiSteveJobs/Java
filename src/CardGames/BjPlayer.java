package CardGames;

import java.util.ArrayList;

public class BjPlayer {
    private ArrayList<Card> hand = new ArrayList<>();
    private int money;
    private int sum;
    private boolean casino;
    private boolean blackJack;
    private boolean over;
    public BjPlayer(boolean isCasino){
        this.casino = isCasino;
    }
    public void newHand(int bet, Deck deck){
        this.over = false;
        this.blackJack = false;
        this.money-=bet;
        this.hand = new ArrayList<>();
        this.hand.add(deck.drawCard());
        this.hand.add(deck.drawCard());
        if(countPoints()==21){
            this.blackJack = true;
        }
    }
    public int countPoints(){
        sum = 0;
        hand.sort(new CardsComparator());
        for (Card card:hand) {
            sum+=card.getNumValue();
            if(card.getNumValue() == 11){
                if(sum > 21){
                    sum-=10;
                }
            }
        }
        if(sum > 21){
            this.over = true;
        }
        return sum;
    }
    public void callsCard(Deck deck){
        if(this.casino){
            if(countPoints()<17){
                hand.add(deck.drawCard());
                callsCard(deck);
                countPoints();
            }
        }
        else{
            hand.add(deck.drawCard());
        }
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public boolean isBlackJack() {
        return blackJack;
    }

    public boolean isOver() {
        return over;
    }


}
