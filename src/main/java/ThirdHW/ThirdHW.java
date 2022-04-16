package ThirdHW;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ThirdHW {
    public static void main(String[] args) {

        String[] array = new String[]{"array", "words", "list", "words", "size", "ten", "twenty", "array",
                "duplicate", "method", "string"};
        System.out.println("Array size: " + array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");

        HashSet<String> set = new HashSet<>(Arrays.asList(array));
        System.out.println("Number of unique words: " + set.size());
        System.out.println(set);
        System.out.println("\n");

        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (hm.containsKey(array[i])) {
                int count = hm.get(array[i]);
                hm.put(array[i], count + 1);
            } else hm.put(array[i], 1);
        }
        System.out.println("How many times the word occurs: ");
        System.out.println(hm);
        System.out.println("\n");

        Phonebook phonebook = new Phonebook();
        phonebook.add("A", "123");
        phonebook.add("B", "562");
        phonebook.add("C", "775");
        phonebook.add("A", "545");
        phonebook.add("C", "632");
        phonebook.get("A");
        phonebook.get("B");
        phonebook.get("C");

    }
}
