package Core_Interfaces.List;

import java.util.Arrays;
import java.util.List;

public class List_Demo {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("Apple","Banana","Date");
        words.sort(null);
        System.out.println(words);

    }
}
