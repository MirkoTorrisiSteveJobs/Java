package immobiliare;

import java.util.ArrayList;
import java.util.Scanner;
import rubric.CSV;

public class HouseRetail {
    public static void main(String[] args){
        String file = "C:\\Users\\Mirko\\Desktop\\houses.txt";
        ArrayList<House> houses = new ArrayList<>();
        ArrayList<String[]> data = CSV.read(file);
        for(String[]array:data){
           int distance = Integer.parseInt(array[0]);
           int surface = Integer.parseInt(array[1]);
           String address = array[2];
           houses.add(new House(distance,surface,address));
        }
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\u001B[34mBENVENUTI NELL'AGENZIA IMMOBILIARE\u001B[0m");
            System.out.println("\u001B[33m1 - VISUALIZZA CASE\n2 -INSERISCI NUOVA CASA\n3 -ESCI\u001B[0m");
            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    for (House house : houses) {
                        System.out.println(house.toString());
                    }
                    break;
                case 2:
                    System.out.println("\u001B[34mInserire indirizzo dell'immobile: \u001B[0m");
                    String address = scan.nextLine();
                    System.out.println("\u001B[34mInserire distanza dal mare: \u001B[0m");
                    int distance = Integer.parseInt(scan.nextLine());
                    System.out.println("\u001B[34mInserire superfice in metri quadri: \u001B[0m");
                    int surface = Integer.parseInt(scan.nextLine());
                    House house = new House(distance, surface, address);
                    houses.add(house);
                    CSV.writeAppend(file, house.toStringForCSV()+"\n");
                    System.out.println("\u001B[34mIMMOBILE INSERITO CON SUCCESSO\u001B[0m");
                    break;
                case 3:
                    return;

            }
        }
    }
}
