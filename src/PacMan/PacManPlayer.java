package PacMan;

public class PacManPlayer{
    private int direction;
    private int points;
    private int[] coords;
    public PacManPlayer(int r, int c){
        this.coords = new int[]{r, c};
    }

    public void move(){
        System.out.println(this.direction);
        switch (this.direction){
            case 2:
                this.coords[0]++;
                break;
            case 4:
                this.coords[1]--;
                break;
            case 8:
                this.coords[0]--;
                break;
            case 6:
                this.coords[1]++;
                break;
        }
    }
    public boolean hasTouch(PacManPlayer phantom){
        if(this.coords[0] == phantom.getCoords()[0] && this.coords[1] == phantom.getCoords()[1]){
            return true;
        }
        return false;
    }
    public void eatToken(){
        this.points++;
    }
    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getPoints() {
        return points;
    }

    public int[] getCoords() {
        return coords;
    }

    public void setCoords(int[] coords) {
        this.coords = coords;
    }
}
