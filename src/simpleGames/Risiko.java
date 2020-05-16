package simpleGames;

import java.util.*;

public class Risiko {
    int attLoss;
    int defLoss;

    public Risiko(){}
    public void play( Integer[] arrAtt, Integer[] arrDef) {




        int min = Math.min(arrAtt.length,arrDef.length );
//      dado piu alto dell'attacco confrontato con il dado piu alto della difesa, se il confronto è a favore dell'attacco vince, sennò vince la difesa, in caso di pareggio vince comunque la difesa
// ordino i dadi di attacco e difesa dal più alto al piu basso

        Arrays.sort(arrAtt, Collections.reverseOrder());
        Arrays.sort(arrDef, Collections.reverseOrder());

        for(int i = 0; i < min; i++){
            if(arrAtt[i] > arrDef[i]){
                defLoss++;
            }
            else{
                attLoss++;
            }
        }
        System.out.println("L'attacco ha perso "+attLoss+" carri armati, la difesa ha perso "+defLoss+" carri armati");
    }

    public static class Game01{
        //test per verificare il sort in maniera discendente e anche il funzionamento del min per controllare quale array sia più piccolo
        public static void main(String[] args) throws Exception{
            Risiko risiko = new Risiko();
            risiko.play( new Integer []{2,3,4,5,6} , new Integer []{2,2});
        }
    }
    public static class Game02{
        public static void main(String[] args) throws Exception{
            //ci aspettiamo che che la difesa perda un solo carroarmato, l'attacco non ne perde
            Risiko risiko = new Risiko();
            risiko.play( new Integer []{5,3,6,6} , new Integer []{2});
        }
    }
    public static class Game03{
        public static void main(String[] args) throws Exception{
            Risiko risiko = new Risiko();
            //ci aspettiamo che l'attacco perda due carri armati , la difesa 0
            risiko.play( new Integer []{5,6} , new Integer []{2,3,4,5,6,1});
        }
    }
    public static class Game04{
        public static void main(String[] args) throws Exception{
            Risiko risiko = new Risiko();
            //ci aspettiamo che l'attacco perda due carri armati , la difesa 0
            risiko.play( new Integer []{5,6,1,2} , new Integer []{2,3,4,1});
        }
    }
}

