package BombField;

public class Box {
    private int value;
    private boolean cover = true;
    public Box(int value){
        this.value = value;
    }

    public int getValue() { return value; }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isCover() {
        return cover;
    }

    public void setCover(boolean cover) {
        this.cover = cover;
    }

    public String toString(){
        if(this.value == -1) {
            return "\uD83D\uDCA5";
        }
        else if(this.value == 0){
            return "   ";
        }
        else {
            return String.valueOf(this.value)+" ";
        }
    }
}
