package rubric;

import java.util.Calendar;

public class CFmaker {
    private String parseName(String name){
        name = name.toLowerCase();
        String first3 ="";
        for(int i=0; i <name.length(); i++ ){
            if(!(name.charAt(i) == 'a') && !(name.charAt(i) == 'e') && !(name.charAt(i) == 'i') && !(name.charAt(i) == 'o') && !(name.charAt(i) == 'u') && !(name.charAt(i) == ' ')){
                first3+=name.charAt(i);
            }
        }
        while(first3.length() <=3) {
            for (int i = 0; i < name.length(); i++) {
                if ((name.charAt(i) == 'a') || (name.charAt(i) == 'e') || (name.charAt(i) == 'i') || (name.charAt(i) == 'o') || (name.charAt(i) == 'u')) {
                    first3 += name.charAt(i);
                }
            }
        }
        return first3.substring(0,3).toUpperCase();
    }
    public String craftCf(String name, String surname, String year){
        if(name.contains(" ")){
            return parseName(surname) + parseName(name).substring(0,2) + name.charAt(name.indexOf(' ')+1) +year.substring(2,4);
        }
            return parseName(surname) + parseName(name) +year.substring(2,4);
    }
}
