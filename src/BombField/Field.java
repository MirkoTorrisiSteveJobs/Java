package BombField;

import java.util.ArrayList;
import java.util.Collections;

public class Field {
    private Box[][] field;
    private int size;
    public boolean gameOver = false;

    public Field(int size) {
        this.size = size;
        this.field = setField(this.size);
        setBoxes();
    }
    public void checkBomb(int x, int y){
        if(this.field[x][y].getValue() == -1){
            this.gameOver = true;
        }
    }
    private Box[][] setField(int size) {
        ArrayList<Box> container = generateField(size);
        Collections.shuffle(container);
        Box[][] field = new Box[size][size];
        int count = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                field[i][j] = container.get(count);
                count++;
            }
        }
        return field;
    }
    private ArrayList<Box> generateField(int size){
        ArrayList<Box> array = new ArrayList<Box>();
        switch (size){
            case 9:
                for(int i = 0; i < 10; i ++){
                    array.add(new Box(-1));
                }
                for(int i = 10; i < 81; i++){
                    array.add(new Box(0));
                }
                return array;
            case 16:
                for(int i = 0; i < 40; i ++){
                    array.add(new Box(-1));
                }
                for(int i = 40; i < 256; i++){
                    array.add(new Box(0));
                }
                return array;
            case 30:
                for(int i = 0; i < 99; i ++){
                    array.add(new Box(-1));
                }
                for(int i = 99; i < 900; i++){
                    array.add(new Box(0));
                }
                return array;
        }
        return array;
    }
    private void setBoxes(){
        for(int i = 0; i < this.field.length; i++){
            for(int j = 0; j < this.field[i].length; j++){
                int count = 0;
                if(this.field[i][j].getValue()!= -1){
                try {
                    if (this.field[i - 1][j - 1].getValue() == -1) {
                        count++;
                    }
                }
                catch (Exception e){ }
                try {
                    if (this.field[i - 1][j].getValue() == -1) {
                        count++;
                    }
                }
                catch (Exception e){  }
                try {
                    if (this.field[i - 1][j + 1].getValue() == -1) {
                        count++;
                    }
                }
                catch (Exception e){  }
                try {
                    if (this.field[i][j - 1].getValue() == -1) {
                        count++;
                    }
                }
                catch (Exception e){  }
                try {
                    if (this.field[i][j + 1].getValue() == -1) {
                        count++;
                    }
                }
                catch (Exception e){  }

                try {
                    if (this.field[i + 1][j - 1].getValue() == -1) {
                        count++;
                    }
                }
                catch (Exception e) {
                }
                try {
                    if (this.field[i + 1][j].getValue() == -1) {
                        count++;
                    }
                }
                catch (Exception e) {
                }
                try{
                    if (this.field[i + 1][j + 1].getValue() == -1) {
                        count++;
                    }
                }
                catch (Exception e){    }
                this.field[i][j].setValue(count);
                }
            }
        }

        }
        public void uncoverBox(int x, int y){
            this.field[x][y].setCover(false);
            if(this.field[x][y].getValue() == 0){
                try {
                    if (this.field[x - 1][y- 1].getValue() != -1 && this.field[x - 1][y- 1].isCover()) {
                        this.field[x - 1][y- 1].setCover(false);
                        uncoverBox(x-1,y-1);
                    }
                }
                catch (Exception e){ }
                try {
                    if (this.field[x - 1][y].getValue() != -1 && this.field[x - 1][y].isCover()) {
                        this.field[x - 1][y].setCover(false);
                        uncoverBox(x-1,y);
                    }
                }
                catch (Exception e){  }
                try {
                    if (this.field[x - 1][y+ 1].getValue() != -1 && this.field[x - 1][y+ 1].isCover()) {
                        this.field[x - 1][y+1].setCover(false);
                        uncoverBox(x-1,y+1);
                    }
                }
                catch (Exception e){  }
                try {
                    if (this.field[x][y- 1].getValue() != -1 && this.field[x][y- 1].isCover()) {
                        this.field[x][y-1].setCover(false);
                        uncoverBox(x,y-1);
                    }
                }
                catch (Exception e){  }
                try {
                    if (this.field[x][y+ 1].getValue() != -1 && this.field[x][y+ 1].isCover()) {
                        this.field[x][y+1].setCover(false);
                        uncoverBox(x,y+1);
                    }
                }
                catch (Exception e){  }

                try {
                    if (this.field[x+1][y-1].getValue() != -1 && this.field[x+1][y-1].isCover()) {
                        this.field[x+1][y-1].setCover(false);
                        uncoverBox(x+1,y-1);
                    }
                }
                catch (Exception e) {
                }
                try {
                    if (this.field[x + 1][y].getValue() != -1 && this.field[x+1][y].isCover()) {
                        this.field[x+1][y].setCover(false);
                        uncoverBox(x+1,y);
                    }
                }
                catch (Exception e) {
                }
                try{
                    if (this.field[x + 1][y + 1].getValue() != -1 && this.field[x+1][y+1].isCover()) {
                        this.field[x+1][y+1].setCover(false);
                        uncoverBox(x+1,y+1);
                    }
                }
                catch (Exception e){    }
            }
        }
    public void showBombs(){
        for(Box[] arr:this.field){
            for(Box box: arr){
                if(box.getValue() == -1){
                    box.setCover(false);
                }
            }
        }
    }
    public String toString(){
        String result = "";
        for(Box [] box : this.field){
            result+="\n";
            for(Box item : box){
                if(item.isCover()){
                    result+=" \u001B[34m\uD83C\uDF0A\u001B[0m";
                }
                else {
                    if (item.getValue() == -1) {
                        result += " \u001B[31m\uD83D\uDCA5\u001B[0m";
                    } else if (item.getValue() == 0) {
                        result += "\u001B[33m[" + item.getValue() + "]\u001B[0m";
                    } else if (item.getValue() == 1) {
                        result += "\u001B[34m[" + item.getValue() + "]\u001B[0m";
                    } else if (item.getValue() == 2) {
                        result += "\u001B[35m[" + item.getValue() + "]\u001B[0m";
                    } else if (item.getValue() == 3) {
                        result += "\u001B[36m[" + item.getValue() + "]\u001B[0m";
                    } else if (item.getValue() == 4) {
                        result += "\u001B[37m[" + item.getValue() + "]\u001B[0m";
                    } else if (item.getValue() == 5) {
                        result += "\u001B[38m[" + item.getValue() + "]\u001B[0m";
                    } else if (item.getValue() == 6) {
                        result += "\u001B[39m[" + item.getValue() + "]\u001B[0m";
                    } else if (item.getValue() == 7) {
                        result += "\u001B[30m[" + item.getValue() + "]\u001B[0m";
                    } else if (item.getValue() == 8) {
                        result += "\u001B[29m[" + item.getValue() + "]\u001B[0m";
                    } else {
                        result += item.getValue();
                    }
                }
            }
        }
        return result;
    }
}
