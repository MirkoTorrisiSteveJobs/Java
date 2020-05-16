package carPark;

import carPark.Car;

import java.util.Scanner;

public class MainCarPark {
    public static void main (String [] args){
        Car car1 = new Car("Audi A5 coupe", 49100, 226);
        Car car2 = new Car("Maserati Ghibli", 72200, 260);
        Car car3 = new Car("Porsche Macan S", 62000, 225);
        Car car4 = new Car("Fiat 600", 699, 160);
        Car car5 = new Car("Audi A5 coupe", 49100, 226);
        Car car6 = new Car("Maserati Ghibli", 72200, 260);
        Car car7 = new Car("Porsche Macan S", 62000, 225);
        Car car8 = new Car("Fiat 600", 699, 160);
        Car car9 = new Car("Maserati Ghibli", 72200, 260);
        Park park = new Park(5,2);
        park.insertCar(car1);
        park.insertCar(car2);
        park.insertCar(car3);
        park.insertCar(car4);
        park.insertCar(car5);
        park.insertCar(car6);
        park.insertCar(car7);
        park.insertCar(car8);
        park.insertCar(car9);

        Scanner scan = new Scanner(System.in);
        System.out.println("\nBenvenuto nel parcheggio, inserisci il modello della tua macchina: ");
        String model = scan.nextLine();
        System.out.println("Inserisci la velocità in km/h: ");
        int speed = scan.nextInt();
        System.out.println("Inserisci il prezzo in $: ");
        int price = scan.nextInt();
        System.out.println("Premi [2] o [3] per parcheggiare. Il nostro parcheggio ha "+park.getFloor()+" piani, ognuno con "+park.getSizeFloor()+" posti, per un totale di "+(park.getFloor()*park.getSizeFloor()));

        while(true){
            System.out.println("[1] - visualizza parcheggio [2] - parcheggia nel primo posto libero [3] - parcheggia in un posto specifico [4] - guarda qual è la migliore auto nel parcheggio [5] - cambia auto [6] - rimuovi auto - [7] esci");
            int choice = scan.nextInt();
            switch (choice){
                case 1: {
                    System.out.println(park.printPark());
                    break;
                }
                case 2: {
                    park.insertCar(new Car(model, price, speed));
                    break;
                }
                case 3:{
                    System.out.println("Inserisci il piano del parcheggio: (0 - piano terra | "+(park.getFloor()-1)+" - ultimo piano)");
                    int floor = scan.nextInt();
                    System.out.println("Inserisci il posto che preferisci: (0 | "+(park.getSizeFloor()-1)+")");
                    int slot = scan.nextInt();
                    park.insertCar(new Car(model, price, speed), floor, slot);
                    System.out.println("Buona permanenza.");
                    break;
                }
                case 4: {
                    Car best = park.getBestCar();
                    System.out.println("la migliore macchina nel parcheggio è la "+best.getModel()+" che ha un rapporto velocità/prezzo di "+best.getRatio());
                    break;
                }
                case 5: {
                    scan.nextLine();
                    System.out.println("inserisci il modello della tua macchina: ");
                    model = scan.nextLine();
                    System.out.println("Inserisci la velocità: ");
                    speed = scan.nextInt();
                    System.out.println("Inserisci il prezzo: ");
                    price = scan.nextInt();
                    break;
                }
                case 6: {
                    scan.nextLine();
                    System.out.println("inserisci il modello della tua macchina: ");
                    park.removeCar(scan.nextLine());
                    break;
                }
                case 7:
                    return;
                }
            }
        }
    }

