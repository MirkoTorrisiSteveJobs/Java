package CardGames;

import java.io.File;
import java.util.Stack;

public class NewDeckWithStack {
    private final String FILE_PATH = "/src/CardGames/memory.txt";
    private Deck deck1 = new Deck(10);
    private Stack<Card> stack = new Stack<>();
    public NewDeckWithStack(){
        String filePath = new File("").getAbsolutePath();
        filePath+=FILE_PATH;
        deck1.addCard(filePath);
        deck1.shuffle();
        for(Card card:deck1.getCard()){
            stack.push(card);
        }
    }
    public Stack<Card> getStack(){
        return this.stack;
    }
    public Card popCard(){
        return stack.pop();
    }
}
