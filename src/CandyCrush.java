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
        switch (combo){
            case 3: {
                switch (candyCombo.getName()) {
                    case "Lollipop":
                        this.points += 3;
                        break;
                    case "Candy":
                        this.points += 6;
                        break;
                    case "Chocolate":
                        this.points += 12;
                        break;
                    case "Cookie":
                        this.points += 24;
                        break;
                }
                break;
            }
            case 4:{
                switch (candyCombo.getName()){
                    case  "Lollipop":
                        this.points += 6;
                        break;
                    case  "Candy":
                        this.points += 12;
                        break;
                    case  "Chocolate":
                        this.points += 24;
                        break;
                    case  "Cookie":
                        this.points += 48;
                        break;
                }
                break;
            }
        }
    }

    public void checkOrizontalVertical() {
        for (int i = 0; i < grid.length; i++) {
            for (int n = 0; n <= grid[i].length-3 ; n++) {
                    if (grid[i][n].toString().equals(grid[i][n + 1].toString()) && grid[i][n + 1].toString().equals(grid[i][n + 2].toString())) {
                        try {
                            if (grid[i][n].toString().equals(grid[i][n + 1].toString()) && grid[i][n + 1].toString().equals(grid[i][n + 2].toString()) && grid[i][n + 2].toString().equals(grid[i][n + 3].toString())) {
                                destroyX(4, i, n);
                                countPoints(4, i, n);
                                System.out.println("ricomincio");
                                checkOrizontalVertical();
                            } else {
                                destroyX(3, i, n);
                                countPoints(3, i, n);
                                System.out.println("ricomincio");
                                checkOrizontalVertical();
                            }
                        } catch (Exception e){}
                    }
                }
            }
        for (int i = 0; i <= grid.length-3; i++) {
            for (int n = 0; n < grid[i].length; n++) {
                    if (grid[i][n].toString().equals(grid[i + 1][n].toString()) && grid[i + 1][n].toString().equals(grid[i + 2][n].toString())) {
                        try {
                            if (grid[i][n].toString().equals(grid[i + 1][n].toString()) && grid[i + 1][n].toString().equals(grid[i + 2][n].toString()) && grid[i + 2][n].toString().equals(grid[i + 3][n].toString())) {
                                destroyY(4, i, n);
                                countPoints(4, i, n);
                                System.out.println("ricomincio");
                                checkOrizontalVertical();

                            } else {
                                destroyY(3, i, n);
                                countPoints(3, i, n);
                                System.out.println("ricomincio");
                                checkOrizontalVertical();
                            }
                        } catch (Exception e) {

                        }
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
        if (points > 150){
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
