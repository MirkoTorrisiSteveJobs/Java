package CardGames;

import java.util.Comparator;

public class CardsComparator implements Comparator<Card> {
    @Override
    public int compare(Card a, Card b) {
        return a.getNumValue() < b.getNumValue() ? -1 : a.getNumValue() == b.getNumValue() ? 0 : 1;
    }
}