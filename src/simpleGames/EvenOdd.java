package simpleGames;

import java.util.Scanner;

public class EvenOdd {
    private  int pcNumber;
    private int win;
    private int lose;

    public EvenOdd(){ }
    private int getPcNumber(){
        return (int)(Math.random() * 6);
    }
    private void play(boolean even, int yourNumber){
        if(yourNumber >5 || yourNumber< 0){
            System.out.println("ma sei bestia? ho detto TRA 0 E 5, quante mani usi? coglione");
            return;
        }
        this.pcNumber = getPcNumber();
        System.out.println("io butto "+pcNumber);
        System.out.println("il risultato è "+(pcNumber+yourNumber));
        if(even){
            if ((pcNumber + yourNumber)%2 == 0){
                System.out.println("Hai vinto");
                this.win++;
            }
            else{
                System.out.println("Hai perso");
                this.lose++;
            }
        }
        else{
            if ((pcNumber + yourNumber)%2 == 0){
                System.out.println("Hai perso");
                this.lose++;
            }
            else{
                System.out.println("Hai vinto");
                this.win++;
                }
            }
        }
        private void getResult() {
            System.out.println("Hai vinto " + win + " volte");
            System.out.println("Hai perso " + lose + " volte");
            if (win > lose) {
                System.out.println("mi hai macinato...bravo");
            } else if (win < lose) {
                System.out.println("mi sa che ti ho rotto il culo");
            } else {
                System.out.println("abbiamo pareggiato e te ne vai così.. mah");
            }
        }
            public void start(){
                Scanner scan = new Scanner(System.in);
                while (true){
                    System.out.println("Pari o dispari? 0 = pari 1 = dispari (qualsiasi altro numero per uscire)");
                    int choice = scan.nextInt();
                    if (choice == 0){
                        System.out.println("butta un numero da 0 a 5");
                        int number = scan.nextInt();
                        play(true, number);
                    }
                    else if(choice == 1){
                        System.out.println("butta un numero da 0 a 5");
                        int number = scan.nextInt();
                        play(false, number);
                    }
                    else {
                        getResult();
                        System.out.println("arrivederci e grazie");
                        return;
                    }
            }
    }
}
