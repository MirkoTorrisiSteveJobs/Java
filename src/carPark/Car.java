package carPark;

public class Car {
    private double price;
    private double speed;
    private String model;
    public Car(String model, int price, int speed){
        this.price = price;
        this.speed = speed;
        this.model = model;
    }
    public double getRatio(){
        return speed/price;
    }
    public String printCar(){
        return model + " - max speed " + (int)(speed) + " km/h price: "+ (int)(price) + "$ - ratio speed/price: "+getRatio() ;
    }
    public String getModel(){
        return model;
    }
}
