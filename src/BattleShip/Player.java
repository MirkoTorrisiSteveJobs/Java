package BattleShip;

import java.util.ArrayList;

public class Player {
    private ArrayList<Ship> ships;
    private ArrayList<int []>shots;
    private int[][] grid;
    public Player(int size){
        this.grid = new int[size][size];
        this.shots = new ArrayList<>();
        this.ships = new ArrayList<>();
    }
    public void loadShip(Ship ship){
        this.ships.add(ship);
    }
    public ArrayList<Ship> getShips() {
        return ships;
    }

    public ArrayList<int[]> getShots() {
        return shots;
    }

    public int[][] getGrid() {
        return grid;
    }
}
