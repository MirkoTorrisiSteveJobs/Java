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
}