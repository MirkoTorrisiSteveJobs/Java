package SnakeGame.Snake;

import rubric.CSV;

import java.util.ArrayList;
import java.util.Random;

public class SnakeGame {
    private  final String SCORES_PATH= "C:\\Users\\User\\IdeaProjects\\Games\\src\\SnakeGame\\view\\resources\\scores.csv";
    private int bestScore;
    private int[][] grid;
    private int[] fruit;
    private Snake snake;
    private boolean newRecord = false;
    public boolean hasAte = false;
    public boolean gameOver;
    public SnakeGame(int rows, int cols){
        this.grid = new int[rows][cols];
        this.snake = new Snake((int)(rows/2), 4);
        generateFruit();
        loadSnakeAndFruit();
        parseBestScore();
    }
    private void loadSnakeAndFruit(){
        for(int i = 0; i < this.grid.length; i ++) {
            for (int j = 0;j < this.grid[i].length; j++) {
                this.grid[i][j] = 0;
            }
        }
        this.grid[this.snake.getHead()[0]][this.snake.getHead()[1]] = 1;

        for(int[] coords : this.snake.getTail()){
            this.grid[coords[0]][coords[1]] = 1;
        }
        this.grid[this.fruit[0]][this.fruit[1]] = 2;
    }
    private void generateFruit(){
        Random random = new Random();
        int count = 0;
        while(count < this.snake.getTail().size()) {
            int[] randCoords = new int[]{random.nextInt(this.grid.length), random.nextInt(this.grid[0].length)};
            for (int[] coords : this.snake.getTail()) {
                if (randCoords[0] != coords[0] && randCoords[1] != coords[1] && randCoords[0] != this.snake.getHead()[0] && randCoords[1] != this.snake.getHead()[1]) {
                    this.fruit = randCoords;
                    count++;
                }
                else{
                    count = 0;
                    break;
                }
            }
        }
    }
    public void snakePlay() {
        this.snake.moveSnake(this.snake.getDirection());
        if (snake.eatsHimself() || this.snake.getHead()[0] >= this.grid.length || this.snake.getHead()[0] < 0 || this.snake.getHead()[1] >= this.grid[0].length || this.snake.getHead()[1] < 0) {
            gameOver = true;
            parseBestScore();
            return;
        }
        if (snake.getHead()[0] == fruit[0] && snake.getHead()[1] == fruit[1] ) {
            snake.eatFruit(snake.getTail().get(snake.getTail().size()-1));
            this.hasAte = true;
            generateFruit();
        }
        loadSnakeAndFruit();
    }

    public int[][] getGrid() {
        return grid;
    }

    public int[] getFruit() {
        return fruit;
    }

    public Snake getSnake(){
        return this.snake;
    }
    @Override
    public String toString() {
        String result = "";
        for(int[] row: this.grid){
            result+="\n";
            for(int col: row){
                switch (col){
                    case 0:
                        result+="\u001B[31m\uD83D\uDCA5\u001B[0m";
                        break;
                    case 1:
                        result+="\u001B[33m\uD83D\uDCA5\u001B[0m";
                        break;
                    case 2:
                        result+="\u001B[34m\uD83C\uDF0A\u001B[0m";
                        break;
                }
            }
        }
        return result;
    }
    public void parseBestScore() {

        ArrayList<String[]> data = CSV.read(SCORES_PATH);
        if(data.size()>0){

            bestScore = Integer.parseInt(data.get(0)[0]);
        }

        if(this.snake.getPoints() > bestScore){
            CSV.write(SCORES_PATH,this.snake.getPoints()+",");
            newRecord = true;
        }
    }

    public boolean isNewRecord() {
        return newRecord;
    }

    public int getBestScore() {
        return bestScore;
    }
}
