import javax.lang.model.type.NullType;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Park {
    private int sizeFloor;
    private int floor;
    private Car[][] park;
    public Park(int sizeFloor, int floor){
        this.sizeFloor = sizeFloor;
        this.floor = floor;
        this.park = new Car[floor][sizeFloor];
    }
    public void insertCar(Car car,int floor, int slot){
        if (park[floor][slot] == null ) {
            park[floor][slot] = car;
        }
        else{
            System.out.println("Questo posto è già occupato!!");
        }
    }
    public void insertCar(Car car){
        for(int i = 0; i < park.length; i++){
            for(int n = 0; n <park[i].length; n++){
                if(park[i][n] == null){
                    park[i][n] = car;
                    System.out.println(car.getModel() +" parcheggiata nel piano "+i+ ", posto "+n);
                    return;
                }
            }
        }
        System.out.println("Il parcheggio è pieno... mi dispiace");
        return;
    }
    public void removeCar(String model) {
        for (int i = 0; i < park.length; i++) {
            for (int n = 0; n < park[i].length; n++) {
                if (park[i][n].getModel().equalsIgnoreCase(model)) {
                    park[i][n] = null;
                    System.out.println("piano " + i + ", posto " + n + " adesso è libero");
                    return;
                }
            }
        }
    }
    public Car getBestCar(){
        Car bestCar = park[0][0];
        for(int i = 0; i < park.length; i++){
            for(int n = 0; n < park[i].length; n++){
                if(park[i][n] != null){
                    if(park[i][n].getRatio() > bestCar.getRatio()) {
                        bestCar = park[i][n];
                    }
                }
            }
        }
        return bestCar;
    }
    public String printPark() {
        String result ="";
        for (int i = 0; i < park.length; i++) {
            result += ("\n--------------Piano "+i+" -------");
            for (int n = 0; n < park[i].length; n++) {
                if (park[i][n] != null) {
                    result += "\n"+(park[i][n].printCar());
                } else {
                    result += ("\n[ "+n+" ]");
                }
            }
        }
        return result;
    }
    public int getSizeFloor() {
        return sizeFloor;
    }
    public int getFloor() {
        return floor;
    }
}

