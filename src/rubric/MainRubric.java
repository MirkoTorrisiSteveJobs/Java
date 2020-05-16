package rubric;

import rubric.CSV;

import java.util.ArrayList;
import java.util.Scanner;

public class MainRubric {
    static String file = "C:\\Users\\Mirko\\Desktop\\rubrica2.csv";
    static Rubric rubric = new Rubric();

    public static void main(String[] args) {
        ArrayList<String[]> newAccounts = CSV.read(file);

        for (String[]account : newAccounts) {
            rubric.insertUser(new User(account[0], account[1], account[2], account[3]));
        }
        System.out.println("---RUBRICA---");
        boolean over = false;
        while(!over) {
            rubric.sort();
        System.out.println("-1- mostra numeri\n-2-aggiungi nuovo numero\n-3-modifica un numero\n-4-rimuovi un numero\n-0-esci");
        Scanner scan = new Scanner(System.in);
        int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 0:
                    over = true;
                case 1:
                    for (User contact : rubric.getArrayListContacts()) {
                        System.out.println(contact.toString());
                    }
                    break;
                case 2:
                    System.out.println("Nome: ");
                    String name = scan.nextLine();
                    System.out.println("Cognome: ");
                    String surname = scan.nextLine();
                    System.out.println("Numero: ");
                    String number = scan.nextLine();
                    System.out.println("Indirizzo: ");
                    String address = scan.nextLine();
                    rubric.insertUser(new User(name, surname, number, address));
                    String content = name + "," + surname + "," + number + "," + address + "\n";
                    CSV.writeAppend(content, file);
                    break;
                case 3:
                    System.out.println("digitare nome o cognome del contatto da modificare: ");
                    ArrayList<User> result = rubric.search(scan.nextLine());
                    int sel = 0;
                    for (User user : result) {
                        int i = 0;
                        System.out.println(i + " " + user.toString());
                    }
                    if (result.size() > 1) {
                        System.out.println("seleziona il contatto");
                        sel = Integer.parseInt(scan.nextLine());
                    }
                    System.out.println("Nome: ");
                    result.get(sel).setName(scan.nextLine());
                    System.out.println("Cognome: ");
                    result.get(sel).setSurname(scan.nextLine());
                    System.out.println("Numero: ");
                    result.get(sel).setNumber(scan.nextLine());
                    System.out.println("Indirizzo: ");
                    result.get(sel).setAddress(scan.nextLine());
                    rubric.writeRubric(file);
                    break;
                case 4:
                    System.out.println("digitare nome o cognome del contatto da eliminare: ");
                    ArrayList<User> result2 = rubric.search(scan.nextLine());
                    int sel2 = 0;
                    for (User user : result2) {
                        int i = 0;
                        System.out.println(i + " " + user.toString());
                        i++;
                    }
                    if (result2.size() > 1) {
                        System.out.println("seleziona il contatto");
                        sel2 = Integer.parseInt(scan.nextLine());
                    }
                    rubric.deleteUser(result2.get(sel2));
                    rubric.writeRubric(file);


            }
        }
    }
}