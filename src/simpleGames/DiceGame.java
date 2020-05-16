package simpleGames;

import java.util.Scanner;

public class DiceGame {
    private int win;
    private int lose;
    private int draw;
    public DiceGame(){}
    private void play(){
        int pc1 = (int)(Math.random()*6 +1);
        int pc2 = (int)(Math.random()*6 +1);
        int player1 = (int)(Math.random()*6 +1);
        int player2 = (int)(Math.random()*6 +1);
        System.out.println("I tuoi dadi sono "+player1+" - "+player2);
        System.out.println("I miei dadi sono "+pc1+" - "+pc2);
        if(Math.max(pc1,pc2) > Math.max(player1,player2)){
            System.out.println("Ho vinto io mi sa..");
            lose++;
        }
        else if(Math.max(player1,player2)>Math.max(pc1,pc2)){
            System.out.println("Hai vinto tu!");
            win++;
        }
        else{
            if(Math.min(player1,player2) > Math.min(pc1,pc2)){
                System.out.println("Hai vinto tu con il dado più basso");
                win++;
            }
            else if(Math.min(player1,player2)< Math.min(pc1,pc2)){
                System.out.println("Ho vinto io con il dado più basso");
            }
            else{
            System.out.println("abbiamo pareggiato O.o");
            draw++;}
        }
    }
    private void getResult(){
        System.out.println("Vittorie: "+win+"\nSconfitte: "+lose+"\nPareggi: "+draw+"\nArrivederci e grazie.");
    }
    public void start(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Premi Y per lanciare i dadi, qualsiasi altra cosa per uscire");
            if(scan.nextLine().equalsIgnoreCase("Y")){
                play();
            }
            else{
                getResult();
                return;
            }
        }
    }
}
