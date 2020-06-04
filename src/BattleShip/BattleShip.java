package BattleShip;


public class BattleShip {
    Player player;
    Player opp;
    private int size;
    BattleShip(int size){
        this.size = size;
        this.player = new Player(size);
        this.opp = new Player(size);
    }
    public boolean checkIfShipisValid(int[][] coordinates, int size){
        for(int[]coords:coordinates){
            if(coords[0]<0 |coords[0]>=size | coords[1]<0 |coords[1]>=size){
                return false;
                }
            }
        return true;
        }

        public boolean checkIfShipSCollide(Player player, int[] arr){
        for(int i = 0; i < player.getShips().size(); i ++){
           for(int[] xy: player.getShips().get(i).getCoordinates()){
               if(xy[0] == arr[0] && xy[1] == arr[1]){
                   return true;
               }
            }
        }
        return false;
    }
    public void loadHits(){
        for(int[] shot: opp.getShots()){
            player.getGrid()[shot[0]][shot[1]] = -1;
        }
        for(int[] shot: player.getShots()){
            if(opp.getGrid()[shot[0]][shot[1]] == 1 || opp.getGrid()[shot[0]][shot[1]] == -2){
                opp.getGrid()[shot[0]][shot[1]] = -2;
            }
            else {
                opp.getGrid()[shot[0]][shot[1]] = -1;
            }
        }
    }
    public void loadShips(){
        for (Ship ship:player.getShips()){
            for (int[]coords:ship.getCoordinates()){
                player.getGrid()[coords[0]][coords[1]] = 1;
            }
        }
        for (Ship ship:opp.getShips()){
            for (int[]coords:ship.getCoordinates()){
                opp.getGrid()[coords[0]][coords[1]] = 1;
            }
        }
    }
    public boolean shot(int x, int y, Player player, Player opp){
        int[] arr = {x,y};
        for (int[]shots:player.getShots()){
            if(shots[0] == arr[0] && shots[1] == arr[1]){
                return false;
            }
        }
        player.getShots().add(arr);
        for(Ship ship:opp.getShips()){
            ship.checkShot(x,y);
        }
        return true;
    }
    public boolean youLose() {
        for (Ship ship : player.getShips()) {
            if (ship.shipGone()) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    public boolean youWin(){
        for(Ship ship:opp.getShips()){
            if(ship.shipGone()){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    public String toString(){
        String result="";
        for(int i = 0; i < opp.getGrid().length; i ++) {
            result += "\n" + i + " ";
            for (int j = 0; j < opp.getGrid()[i].length; j++) {
                if (opp.getGrid()[i][j] == -2) {
                    result += "\u001B[31m\uD83D\uDCA5\u001B[0m";
                }
                else if(opp.getGrid()[i][j] == -1) {
                    result += "\u001B[33m\uD83D\uDCA5\u001B[0m";
                }
                else{
                    result += "\u001B[34m\uD83C\uDF0A\u001B[0m";
                }
            }
        }
        result+="\n ";
        for(int i = 0; i < player.getGrid().length; i ++){
            result+= " "+i+"";
        }
        for(int i = 0; i < player.getGrid().length; i ++){
            result+="\n"+i+" ";
            for(int j = 0; j < player.getGrid()[i].length; j++){
                if(player.getGrid()[i][j] == 0){
                    result +=  "\u001B[34m\uD83C\uDF0A\u001B[0m";
                }
                else if(player.getGrid()[i][j] == -1){
                    result += "\u001B[31m\uD83D\uDCA5\u001B[0m";
                }
                else if(player.getGrid()[i][j] == 1){
                    result+= "\uD83D\uDEF3";
                }
            }
        }
        return result;
    }

}
