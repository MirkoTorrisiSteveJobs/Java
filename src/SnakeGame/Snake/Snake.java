package SnakeGame.Snake;


import java.util.ArrayList;

public class Snake {
    private int [] head;
    private int direction;
    private int points;
    private ArrayList<int[]> tail = new ArrayList<>();
    public Snake(int row, int col){
        this.head = new int[]{row, col};
        this.tail.add(new int[]{row,col-3});
        this.tail.add(new int[]{row,col-2});
        this.tail.add(new int[]{row,col-1});
    }
    public void eatFruit(int[] fruit){
        this.tail.add(fruit);
        this.points+= 10;
    }
    public boolean eatsHimself(){
        for(int[] coord:this.tail){
            if(this.head[0] == coord[0] && this.head[1] == coord[1]){
                return true;
            }
        }
        return false;
    }
    public void moveSnake(int direction){
        int[] headTemp = {this.head[0], this.head[1]};
        switch (direction){
            case 8:
                this.tail.add(headTemp);
                this.head[0]--;
                this.tail.remove(0);
                break;
            case 2:
                this.tail.add(headTemp);
                this.head[0]++;
                this.tail.remove(0);
                break;
            case 4:
                this.tail.add(headTemp);
                this.head[1]--;
                this.tail.remove(0);
                break;
            case 6:
                this.tail.add(headTemp);
                this.head[1]++;
                this.tail.remove(0);
                break;
        }
    }

    public int[] getHead() {
        return this.head;
    }

    public ArrayList<int[]> getTail() {
        return tail;
    }

    public int getDirection() {
        return direction;
    }

    public int getPoints() {
        return points;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

}
