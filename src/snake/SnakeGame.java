package snake;

import java.util.LinkedList;
import java.util.Random;

public class SnakeGame {
    enum Move {TOP, BOTTOM, LEFT, RIGHT};

    enum Status {IN_GAME, LOSE, WIN};


    int[][] grid;
    private Move forbiddenMove = Move.LEFT;
    private Move lastMove = Move.RIGHT;
    public Status currentStatus = Status.IN_GAME;
    LinkedList<Coord> snake = new LinkedList<>();
    private Coord ball;
    private int m;
    private int n;

    public SnakeGame(int n, int m) throws Exception {
        if (n < 9 || m < 9) {
            throw new Exception("grid too small");
        }
        this.n = n;
        this.m = m;
        this.grid = new int[n][m];
        snake.add(new Coord(1, 1));
        snake.addFirst(new Coord(1, 2));
        ballgenerator();
    }


    public void move(Move m) {
        if (m == this.forbiddenMove) return;
        this.lastMove = m;
        Coord head = this.snake.getFirst();
        if (m == Move.RIGHT) {
            if (head.getY() + 1 > this.m) {
                this.currentStatus = Status.LOSE;
                return;
            }
            this.snake.addFirst(new Coord(head.getX(), head.getY() + 1));
            this.forbiddenMove = Move.LEFT;
        } else if (m == Move.LEFT) {
            if (head.getY() - 1 < 0) {
                this.currentStatus = Status.LOSE;
                return;
            }
            this.snake.addFirst(new Coord(head.getX(), head.getY() - 1));
            this.forbiddenMove = Move.RIGHT;
        } else if (m == Move.TOP) {
            if (head.getX() - 1 < 0) {
                this.currentStatus = Status.LOSE;
                return;
            }
            this.snake.addFirst(new Coord(head.getX() - 1, head.getY()));
            this.forbiddenMove = Move.BOTTOM;
        } else if (m == Move.BOTTOM) {
            if (head.getX() + 1 > this.n) {
                this.currentStatus = Status.LOSE;
                return;
            }
            this.snake.addFirst(new Coord(head.getX() + 1, head.getY()));
            this.forbiddenMove = Move.TOP;
        }
        this.snake.removeLast();
    }

    public String toString() {
        String result = this.currentStatus + "\n";
        for (int x = 0; x < this.grid.length; x++) {
            for (int y = 0; y < this.grid[x].length; y++) {
                if (this.snake.getFirst().equals(new Coord(x, y))) {
                    result += "[\u001b[31mT\u001b[31m]";
                    // result += "[🔴]";
                } else if (this.snake.contains(new Coord(x, y))) {
                    result += "\u001b[32m[1]\u001b[32m";
                    // result += "[🔸]";
                } else if (this.ball.equals(new Coord(x, y))) {
                    result += "\u001b[35m[" + -1 + "]\u001b[35m";
                    // result +="[🔵]";

                } else {
                    // result += "[" + x +"," + y +"]";
                    result += "\u001b[37m[" + 0 + "]\u001b[37m";
                }

            }
            result += "]\n";
        }
        return result;
    }

    public void ballgenerator() {
        Random rand = new Random();
        boolean check = false;
        while (!check) {
            int x = rand.nextInt(this.grid.length);
            int y = rand.nextInt(this.grid[0].length);
            if (!this.snake.contains(new Coord(x, y))) {
                this.ball = new Coord(x, y);
                check = true;
            }
        }
    }

    public void eatBall() {
        if (this.snake.getFirst().equals(this.ball)) {
            snake.addFirst(new Coord(this.snake.getFirst().getX(), this.snake.getFirst().getY()));
            ballgenerator();
        }
    }

    public void smash() {
        for (int i = 1; i < this.snake.size(); i++) {
            if (this.snake.get(i).equals(this.snake.getFirst())) { // va in conflitto con this.forbiddenMove

                this.currentStatus = Status.LOSE;
            }
        }
    }

    public int[][] getGrid() {
        return grid;
    }

    public LinkedList<Coord> getSnake() {
        return snake;
    }

    public Coord getBall() {
        return ball;
    }
}
