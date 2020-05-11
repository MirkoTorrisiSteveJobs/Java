import java.util.ArrayList;
import java.util.Collections;

public class Rubric implements Sort {
    private User[] arrayContacts;
    private ArrayList<User> arrayListContacts = new ArrayList();
    private int counter = 0;

    public Rubric() {
        ArrayList<User> arrayContacts = new ArrayList<User>();
    }

    public Rubric(int size) {
        arrayContacts = new User[size];
    }

    public void insertUser(User user) {
        arrayListContacts.add(user);
    }

    public int getRubricLength() {
        // arrayContacts.length;
        return arrayListContacts.size();
    }

    public void deleteUser(User user) {
        arrayListContacts.remove(user);
    }

    public User getIndex(int index) {
        // arrayContacts[index];
        return arrayListContacts.get(index);
    }

    public ArrayList<User> search(String text) {
        ArrayList<User> res = new ArrayList();
        for (User u : arrayListContacts) {
            if (u.getName().toLowerCase().contains(text.toLowerCase()) || u.getSurname().toLowerCase().contains(text.toLowerCase())) {
                res.add(u);
            }
        }
        return res;
    }

    public void writeRubric(String file) {
        String res = "";

        for (User contact : this.getArrayListContacts()) {
            res += contact.getName() + "," + contact.getSurname() + "," + contact.getNumber() + "," + contact.getAddress() + "\n";
        }
        CSV.write(file, res);
    }

    public void appendRubric(String file) {
        String res = "";

        for (User contact : this.getArrayListContacts()) {
            res += contact.getName() + "," + contact.getSurname() + "," + contact.getNumber() + "," + contact.getAddress() + "\n";
        }
        CSV.writeAppend(file, res);
    }


    public ArrayList<User> getArrayListContacts() {
        return arrayListContacts;
    }

    @Override
    public void sort() {
        for (int i = 0; i <arrayListContacts.size(); i++) {
            for (int j = 0; j < arrayListContacts.size(); j++) {
                if (arrayListContacts.get(i).getName().compareTo(arrayListContacts.get(j).getName()) < 0) {
                    Collections.swap(arrayListContacts, i, j);
                }
                else if(arrayListContacts.get(i).getName().compareTo(arrayListContacts.get(j).getName()) == 0) {
                    if (arrayListContacts.get(i).getSurname().compareTo(arrayListContacts.get(j).getSurname()) < 0) {
                        Collections.swap(arrayListContacts, i, j);
                    }
                }
            }
        }
    }
}
