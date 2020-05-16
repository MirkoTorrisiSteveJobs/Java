package candyCrush;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Switchable {
    Object [][] grid;
    public Switchable (int x) {
        grid = new Object [x][x];
        itemsGenerator();
    }
    public String toString() {
        String result = "";

        for (int i = 0; i < this.grid.length; i++) {
            result += "\n"+i;
            for (int j = 0; j < this.grid[i].length; j++) {
                result += "[" + this.grid[i][j] + "]";
            }
        }
        return result;
    }
    void itemsGenerator() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                this.grid[i][j] = new Object();
            }
        }
    }
    public int[] getItem(Object obj){
        int[] arr = new int[2];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].equals(obj)) {
                     arr[0] = i;
                     arr[1] = j;
                    }
                }
            }
        return arr;
    }
    public Object findItem(int col, int row){
        return grid[row][col];
    }
    public void switchItems(int row1, int col1, int row2, int col2){
        try {
            if (canBeSwitched(row1, col1, row2, col2)) {
                Object temp = grid[row1][col1];
                grid[row1][col1] = grid[row2][col2];
                grid[row2][col2] = temp;
            }
        }
        catch (Exception e){
            return;
        }

    }
    boolean canBeSwitched(int row1, int col1, int row2, int col2){
            if (col1 == col2) {
                if (row1 == row2 - 1 || row1 == row2 + 1) {
                    return true;
                }
            } else if (row1 == row2) {
                if (col1 == col2 + 1 || col1 == col2 - 1) {
                    return true;
                }
            }
            return false;
    }
}