package Core_Interfaces.Map.HashMap;
import java.util.*;;




public class HashMapIteration {
    public static void main(String[] args) {
//------> Iterating Over a HashMap

        Map<String, String> map = new HashMap<>();
        map.put("Singhal Puri", "6410");
        map.put("Hariom Puri", "1122");

        // Iterating over entries
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Iterating over keys
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        // Iterating over values
        for (String value : map.values()) {
            System.out.println(value);
        }













    }
}
