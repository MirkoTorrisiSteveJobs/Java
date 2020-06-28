package CarRace;

public class CarRaceMain {
    public static void main(String[]args){
        Car ferrari = new Car("\u001B[31m\uD83C\uDFCE\u001B[0m");
        Car porsche = new Car("\u001B[32m\uD83C\uDFCE\u001B[0m");
        Car mercedes = new Car("\u001B[33m\uD83C\uDFCE\u001B[0m");
        Car maserati = new Car("\u001B[34m\uD83C\uDFCE\u001B[0m");
        ferrari.start();
        porsche.start();
        mercedes.start();
        maserati.start();
    }
}
