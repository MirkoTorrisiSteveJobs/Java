package CarRace;

public class Car extends Thread {
    private int position;
    public Car(String str){
        super(str);
    }

    @Override
    public void run() {
        try{
            while (this.position<500) {
                sleep((int) (Math.random() * 10));
                this.position++;
            }
            System.out.println(getName()+" HA RAGGIUNTO IL TRAGUARDO");
        }
        catch (InterruptedException e){}
    }
    public String toString(){
        String res = "";
        for (int i = 0; i < this.position; i++) {
            res+="  ";
        }
        res+=getName();
        return res;
    }

    public int getPosition() {
        return this.position;
    }
}
