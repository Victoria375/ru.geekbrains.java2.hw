package ThirdHW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Phonebook {

    private HashMap<String, List<String>> hm = new HashMap<>();

    public void add(String surname, String number) {
        List<String> phoneNumbers = hm.get(surname);
        if (phoneNumbers != null) {
            phoneNumbers.add(number);
        } else {
            phoneNumbers = new ArrayList<>();
            phoneNumbers.add(number);
            hm.put(surname, phoneNumbers);
        }
    }

    public void get(String surname) {
        System.out.printf("Number %s: %s\n", surname, hm.get(surname));
    }

}
