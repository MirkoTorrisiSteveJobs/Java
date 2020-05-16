package rubric;

public class User {
    private String name;
    private String surname;



    private String number;
    private String address;
    public User(User u) { // costruttore di copia
        this.name = u.getName(); // assegnazione per valore
    }
    public User(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
    }
    public User(String name, String surname, String number, String address) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "\u001B[32m"+name +" "+surname+ "\u001B[0m\tnumber= \u001B[34m"+ number+"\u001B[0m\taddress= "+address;
    }
}