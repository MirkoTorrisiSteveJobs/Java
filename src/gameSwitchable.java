import java.util.Random;

public class gameSwitchable extends Switchable {

    public gameSwitchable(int x) {
        super(x);
    }
    @Override
    void itemsGenerator() {
        super.itemsGenerator();
        int count = 0;
        for(int i = 0; i < grid.length; i++ ) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = count;
                count++;
            }
        }
            Random rand = new Random();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int randomIndexToSwap = rand.nextInt(grid[i].length);
                Object temp = grid[i][randomIndexToSwap];
                grid[i][randomIndexToSwap] = grid[i][j];
                grid[i][j] = temp;
            }
        }
    }

    @Override
    boolean canBeSwitched(int row1, int col1, int row2, int col2){
        if (super.canBeSwitched(row1, col1, row2, col2)){
            if (grid[row1][col1].equals(0) || grid[row2][col2].equals(0) ){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString(){
        String result = "";
        for (int i = 0; i < this.grid.length; i++) {
            result += "\n";
            for (int j = 0; j < this.grid[i].length; j++) {
                if (this.grid[i][j].equals(0)){
                    result += "\u001B[34m["+this.grid[i][j]+"]\u001B[0m";
                }
                else {
                    result += "[" + this.grid[i][j] + "]";
                }
            }
        }
        return result;
    }
    public boolean gameOver(){
        if (grid[0][1].equals(1) && grid[0][2].equals(2) && grid[0][3].equals(3) && grid[1][0].equals(5) && grid[1][1].equals(6) && grid[1][2].equals(7) && grid[1][3].equals(8) && grid[2][0].equals(9) && grid[2][1].equals(10) && grid[2][2].equals(11) && grid[2][3].equals(12) && grid[3][0].equals(13) && grid[3][1].equals(14) && grid[3][2].equals(15)){
            return true;
        }
        return false;
    }
}
