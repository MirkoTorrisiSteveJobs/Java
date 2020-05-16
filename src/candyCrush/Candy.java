package candyCrush;

public class Candy {
    private String emoji;
    private int value;
    private String name;
    public Candy(String name, String emoji, int value) {
        this.name = name;
        this.emoji = emoji;
        this.value = value;
    }
    @Override
    public String toString() {
        return this.emoji;
    }
    public String getName(){
        return this.name;
    }

    public int getValue() {
        return value;
    }
    @Override
    public boolean equals(Object candy1) {
        Candy candy = (Candy)candy1;
        return this.name.equals(candy.name);
    }
}