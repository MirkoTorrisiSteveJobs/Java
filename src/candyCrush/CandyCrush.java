package candyCrush;

public class CandyCrush extends Switchable {
    public int points;
    public CandyCrush(int x){
        super(x);
        for(int i = 0; i < grid.length; i ++){
            for(int n = 0 ; n < grid[i].length;n++){
                grid[i][n] = candyGenerator();
            }
        }
        candyGenerator();
    }
    private Candy candyGenerator() {
        double value = Math.random();
        if (value < 0.25) {
            return new Candy("Lollipop", "\u001B[34m\uD83C\uDF6D\u001B[0m", 10);
        } else if (value < 0.50) {
            return new Candy("Candy", "\u001B[31m\uD83C\uDF6C\u001B[0m", 20);
        } else if (value < 0.75) {
            return new Candy("Chocolate", "\u001B[32m\uD83C\uDF6B\u001B[0m", 30);
        } else {
            return new Candy("Cookie", "\u001B[35m\uD83C\uDF6A\u001B[0m", 40);
        }
    }
    @Override
    public Candy findItem(int row, int col){
        return (Candy) this.grid[row][col];
    }
    private void countPoints(int combo, int row, int col){
        Candy candyCombo = this.findItem(row, col);
        this.points += candyCombo.getValue()*combo;

    }

    public void checkOrizontalVertical() {
        for (int i = 0; i < grid.length; i++) {
            for (int n = 0; n < grid[i].length - 2; n++) {
                    if (grid[i][n].equals(grid[i][n + 1]) && grid[i][n + 1].equals(grid[i][n + 2])) {
                        if (n < grid[i].length-3){
                            if(grid[i][n].equals(grid[i][n + 1]) && grid[i][n + 1].equals(grid[i][n + 2]) && grid[i][n + 2].equals(grid[i][n + 3])) {
                                destroyX(4, i, n);
                                countPoints(4, i, n);
                                checkOrizontalVertical();
                            }
                        }
                        destroyX(3, i, n);
                        countPoints(3, i, n);
                        checkOrizontalVertical();

                    }
                }
        }

        for (int i = 0; i < grid.length - 2; i++) {
            for (int n = 0; n < grid[i].length; n++) {
                    if (grid[i][n].equals(grid[i + 1][n]) && grid[i + 1][n].equals(grid[i + 2][n])) {
                            if (i < grid.length-3) {
                                if (grid[i][n].equals(grid[i + 1][n]) && grid[i + 1][n].equals(grid[i + 2][n]) && grid[i + 2][n].equals(grid[i + 3][n])) {
                                    destroyY(4, i, n);
                                    countPoints(4, i, n);
                                    checkOrizontalVertical();
                                }
                            }
                            destroyY(3, i, n);
                            countPoints(3, i, n);
                            checkOrizontalVertical();
                    }
            }
        }
    }
        private void destroyX(int combo, int startRow, int startCol){
            while(startRow > 0){
                for (int i = 0; i < combo; i ++) {
                    grid[startRow][startCol+i] = grid[startRow-1][startCol+i];
                }
                startRow--;
            }
            for(int i = 0; i < combo; i++ ){
                grid[0][startCol + i] = candyGenerator();
            }
        }
        private void destroyY(int combo, int startRow, int startCol){
            while(startRow >  0){
                grid[startRow+combo-1][startCol] = grid[startRow-1][startCol];
                startRow--;
            }
            for(int i = 0; i < combo; i++ ){
                grid[i][startCol] = candyGenerator();
            }
    }
    public boolean gameOver(){
        if (points > 300){
            return true;
        }
        else {
            return false;
        }
    }
    public int getPoints(){
        return this.points;
    }

}
