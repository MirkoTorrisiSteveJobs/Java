package BattleShip;

public class Ship {
    private int size;
    private int[][] coordinates;
    private int hits;
    public Ship(int size, int[] startCoords, boolean orizz){
        this.size = size;
        this.hits = 0;
        this.coordinates = generateShip(orizz,startCoords);
    }

    public boolean checkShot(int x, int y){
        for(int[]coords : coordinates){
            if(coords[0] == x && coords[1] == y){
                hits++;
                return true;
            }
        }
        return false;
    }
    private int[][] generateShip(boolean orizz, int[]startCoords){
        int[][] coordinates = new int[this.size][2];
        if(orizz){
            for(int i = 0; i < size; i++){
                coordinates[i][1] = startCoords[1]+i;
                coordinates[i][0] = startCoords[0];
            }
        }
        else{
            for(int i = 0; i < size; i++){
                coordinates[i][0] = startCoords[0]+i;
                coordinates[i][1] = startCoords[1];
            }
        }
        return coordinates;
    }
    public int[][] getCoordinates(){
        return this.coordinates;
    }
    public boolean shipGone(){
        return (this.hits == size);
    }

}
