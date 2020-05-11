import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CandyCrush cc = new CandyCrush(6);
        System.out.println(cc.toString());
        while(!cc.gameOver()){
            cc.checkOrizontalVertical();
            System.out.println("i tuoi punti sono: "+cc.getPoints());

            System.out.println(cc.toString());

            System.out.println("selezionare la caramella: (row)");
            int row = Integer.parseInt(scan.nextLine());
            System.out.println("selezionare la caramella: (col)");
            int col = Integer.parseInt(scan.nextLine());

            System.out.println("8 per spostare in alto, 4 a sinistra 6 a destra e 2 in basso. Se la mossa non è valida non succede niente");
            int move = Integer.parseInt(scan.nextLine());
            switch (move){
                case 8:
                    cc.switchItems(row,col, row-1,col);
                    break;
                case 6:
                    cc.switchItems(row,col, row,col+1);
                    break;
                case 2:
                    cc.switchItems(row,col, row+1,col);
                    break;
                case 4:
                    cc.switchItems(row,col, row,col-1);
                    break;
            }
        }
        System.out.println("Hai ottenuto "+ cc.getPoints()+" punti bravo");
    }
}