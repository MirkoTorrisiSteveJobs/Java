package CardGames;

import java.io.File;


public class BlackJackGame {
    private Deck deck1 = new Deck(52);
    private BjPlayer player = new BjPlayer(false);
    private BjPlayer casino = new BjPlayer(true);
    private final String FILE_PATH = "/src/CardGames/blackjack.txt";
    public BlackJackGame(){
        String filePath = new File("").getAbsolutePath();
        filePath+=FILE_PATH;
        this.deck1.addCard(filePath);
        this.deck1.addCard(filePath);
        this.deck1.addCard(filePath);
        this.deck1.addCard(filePath);
        this.deck1.shuffle();
    }
    public void initHand(int bet){
        this.player.newHand(bet,this.deck1);
        this.casino.newHand(bet,this.deck1);
    }

    public BjPlayer getPlayer() {
        return this.player;
    }

    public BjPlayer getCasino() {
        return this.casino;
    }

    public Deck getDeck1() {
        return this.deck1;
    }

    @Override
    public String toString() {
        String res = "\nPLAYER----";
        for(Card card: this.player.getHand()){
            res+=card.getValue()+" ";
        }
        res+="\nCASINO-----";
        for(Card card: this.casino.getHand()){
            res+=card.getValue()+" ";
        }
        res+="\nPLAYER POINTS "+this.getPlayer().countPoints();
        res+="\nCASINO POINTS "+this.getCasino().countPoints();
        return res;
    }
}
