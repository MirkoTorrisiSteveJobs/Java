package CardGames;

public class Card {
    private String value;
    private int numValue;
    private boolean folded = false;
    public Card(String value, int numValue){
        this.value = value;
        this.numValue = numValue;
    }
    public void unFold(){
            this.folded = true;
    }
    public void fold(){
            this.folded = false;
    }

    public boolean isFolded() {
        return folded;
    }

    public String getValue(){
        return this.value;
    }
    public int getNumValue(){
        return this.numValue;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
