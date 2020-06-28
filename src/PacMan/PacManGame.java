package PacMan;

public class PacManGame {
    private int[][]maze;
    private PacManPlayer player;
    private PacManPlayer phantom;
    private PacManPlayer phantom2;
    private PacManPlayer phantom3;
    private PacManPlayer phantom4;
    private int countTokens;
    public boolean gameWin = false;
    public boolean gameOver = false;
    private int level = 1;
    public PacManGame(){
        createWalls(this.level);
        this.player = new PacManPlayer(12,8);
        this.phantom = new PacManPlayer(9,8);
        this.phantom2 = new PacManPlayer(9,9);
        this.phantom3 = new PacManPlayer(9,10);
        this.phantom4 = new PacManPlayer(9,11);

    }
    private void createWalls(int level){
        switch (level){
            case 1:
                this.maze = new int[][]
                       {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,2,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,1},
                        {1,2,1,1,2,1,1,1,2,2,2,2,1,1,1,2,1,1,2,1},
                        {1,2,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,1},
                        {1,2,1,1,2,1,2,1,1,1,1,1,1,2,1,2,1,1,2,1},
                        {1,2,2,2,2,1,2,2,2,1,1,2,2,2,1,2,2,2,2,1},
                        {1,1,2,1,2,1,1,1,2,1,1,2,1,1,1,2,1,2,1,1},
                        {1,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,1},
                        {1,2,1,1,2,1,2,1,8,8,8,8,1,2,1,2,1,1,2,1},
                        {1,2,2,2,2,1,2,1,8,8,8,8,1,2,1,2,2,2,2,1},
                        {1,2,1,1,2,1,2,1,8,8,8,8,1,2,1,2,1,1,2,1},
                        {1,2,2,1,2,1,2,1,1,1,1,1,1,2,1,2,1,2,2,1},
                        {1,1,2,1,2,1,2,2,2,2,2,2,2,2,1,2,1,2,1,1},
                        {1,2,2,1,2,1,2,1,1,1,1,1,1,2,1,2,1,2,2,1},
                        {1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1},
                        {1,2,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,2,1},
                        {1,1,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,1,1},
                        {1,2,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,2,1},
                        {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
                break;
            case 2:
                this.maze = new int[][]
                       {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,1},
                        {1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
                        {1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
                        {1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
                        {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
                        {1,2,1,1,1,2,1,2,1,1,1,1,1,2,1,2,1,1,1,2,1},
                        {1,2,1,1,1,2,1,2,1,1,1,1,1,2,1,2,1,1,1,2,1},
                        {1,2,2,2,2,2,1,2,2,2,1,2,2,2,1,2,2,2,2,2,1},
                        {1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
                        {1,2,2,2,2,2,1,2,2,2,2,2,2,2,1,2,2,2,2,2,1},
                        {1,1,1,1,1,2,1,2,2,2,2,2,2,2,1,2,1,1,1,1,1},
                        {1,1,1,1,1,2,1,2,2,2,2,2,2,2,1,2,1,1,1,1,1},
                        {1,1,1,1,1,2,2,2,1,1,1,1,1,2,2,2,1,1,1,1,1},
                        {1,1,1,1,1,2,1,2,1,1,1,1,1,2,1,2,1,1,1,1,1},
                        {1,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,1},
                        {1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
                        {1,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,1,2,2,2,1},
                        {1,1,1,2,1,2,1,2,1,1,1,1,1,2,1,2,1,2,1,1,1},
                        {1,1,1,2,1,2,1,2,1,1,1,1,1,2,1,2,1,2,1,1,1},
                        {1,2,2,2,2,2,1,2,2,2,1,2,2,2,1,2,2,2,2,2,1},
                        {1,2,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,2,1},
                        {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
                break;
        }
        for(int[]row:this.maze){
            for(int col:row){
                if (col== 2){
                    this.countTokens++;
                }
            }
        }
    }

    private void movePhantom(PacManPlayer phantom){
        int rGap = this.player.getCoords()[0] - phantom.getCoords()[0];
        int cGap = this.player.getCoords()[1] - phantom.getCoords()[1];
        if(rGap > cGap){
            if(rGap > 0) {
                phantom.setDirection(2);
            }
            else{
                phantom.setDirection(8);
            }
            if(!movePlayer(phantom)){
                if(cGap < 0){
                    phantom.setDirection(4);
                }
                else{
                    phantom.setDirection(6);
                }
                movePlayer(phantom);
            }
        }
        else{
            if(cGap > 0) {
                phantom.setDirection(6);
            }
            else{
                phantom.setDirection(4);
            }
            if(!movePlayer(phantom)){
                if(rGap < 0){
                    phantom.setDirection(2);
                }
                else{
                    phantom.setDirection(8);
                }
                movePlayer(phantom);
            }
        }
    }
    private boolean movePlayer(PacManPlayer player){
        switch (player.getDirection()){
            case 2:
                if(this.maze[player.getCoords()[0]+1][player.getCoords()[1]] != 1){
                    player.move();
                    return true;
                }
                break;
            case 4:
                if(this.maze[player.getCoords()[0]][player.getCoords()[1]-1] != 1){
                    player.move();
                    return true;
                }
                break;
            case 6:
                if(this.maze[player.getCoords()[0]][player.getCoords()[1]+1] != 1){
                    player.move();
                    return true;
                }
                break;
            case 8:
                if(this.maze[player.getCoords()[0]-1][player.getCoords()[1]] != 1) {
                    player.move();
                    return true;
                }
                break;
        }
        return false;
    }
    public boolean eatToken(){
        if(this.maze[this.player.getCoords()[0]][this.player.getCoords()[1]] == 2){
            this.player.eatToken();
            countTokens--;
            this.maze[this.player.getCoords()[0]][this.player.getCoords()[1]] = 0;
            return true;
        }
        return false;
    }
    public void gamePlay(){
            movePlayer(this.player);
            if (this.player.getPoints() < 10) {
                movePhantom(this.phantom);
            } else if (this.player.getPoints() < 20) {
                movePhantom(this.phantom);
                movePhantom(this.phantom2);
            } else if (this.player.getPoints() < 30) {
                movePhantom(this.phantom);
                movePhantom(this.phantom2);
                movePhantom(this.phantom3);
            } else {
                movePhantom(this.phantom);
                movePhantom(this.phantom2);
                movePhantom(this.phantom3);
                movePhantom(this.phantom4);
            }
            if (this.player.hasTouch(this.phantom) || this.player.hasTouch(this.phantom2) || this.player.hasTouch(this.phantom3) || this.player.hasTouch(this.phantom4)) {
                this.gameOver = true;
            } else if (this.countTokens == 0) {
                this.gameWin = true;
                this.level++;
                createWalls(level);
            }
    }
    public String toString() {
        String res = "";
        for (int r = 0; r < this.maze.length; r++) {
            res+="\n";
            for (int c = 0; c < this.maze[r].length; c++) {
                if (this.maze[r][c] == 1) {
                    res += "\u001B[34m\uD83C\uDF0A\u001B[0m";
                } else if (this.player.getCoords()[0] == r && this.player.getCoords()[1] == c) {
                    res += "\u001B[31m\uD85D\uDCA5\u001B[0m";
                } else if (this.phantom.getCoords()[0] == r && this.phantom.getCoords()[1] == c) {
                    res += "\u001B[32m\uD83D\uDCA5\u001B[0m";
                }else if (this.phantom2.getCoords()[0] == r && this.phantom2.getCoords()[1] == c) {
                    res += "\u001B[33m\uD83D\uDCA5\u001B[0m";
                }else if (this.phantom3.getCoords()[0] == r && this.phantom3.getCoords()[1] == c) {
                    res += "\u001B[29m\uD83D\uDCA5\u001B[0m";
                }else if (this.phantom4.getCoords()[0] == r && this.phantom4.getCoords()[1] == c) {
                    res += "\u001B[35m\uD83D\uDCA5\u001B[0m";
                } else if (this.maze[r][c] == 2) {
                    res += "\u001B[28m\uD83C\uDF6C\u001B[0m";
                } else if (this.maze[r][c] == 0 || this.maze[r][c] == 8) {
                    res += "  ";
                }
            }
        }
        return res;
    }

    public PacManPlayer getPlayer() {
        return player;
    }

    public PacManPlayer getPhantom() {
        return phantom;
    }

    public PacManPlayer getPhantom2() {
        return phantom2;
    }

    public PacManPlayer getPhantom3() {
        return phantom3;
    }

    public PacManPlayer getPhantom4() {
        return phantom4;
    }

    public int[][] getMaze() {
        return maze;
    }

}
