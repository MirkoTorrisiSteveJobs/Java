package immobiliare;

public class House {
    private int distance;
    private int surface;
    private int finalprice;
    private String address;

    public House(int distance, int surface, String address) {
        this.distance = distance;
        this.surface = surface;
        this.address = address;
        calcPrice();
    }
    public void setFinalprice(int finalprice) {
        this.finalprice = finalprice *this.surface;
    }
    private void calcPrice(){
        if(this.distance <= 200){
            setFinalprice(2000);
        }
        else if(this.distance <= 1000 && this.distance > 200){
            setFinalprice(1500);
        }
        else{
            setFinalprice(1000);
        }
    }
    public String toString(){
        return this.address +" "+this.finalprice + "$";
    }
    public String toStringForCSV(){
        return this.distance+","+this.surface+","+this.address;
    }

    public int getDistance() {
        return this.distance;
}
    public int getSurface() {
        return this.surface;
    }
    public String getAddress(){
        return this.address;
    }
}
