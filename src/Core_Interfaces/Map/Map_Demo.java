package Core_Interfaces.Map;
import java.util.Map;
import java.util.HashMap;

public class Map_Demo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // 1. Insert
        map.put("Apple", 10);
        map.put("Banana", 20);

        // 2. Get value by key
        int apples = map.get("Apple"); // 10

        // 3. Check if key exists
        boolean hasBanana = map.containsKey("Banana"); // true

       // 4. Remove a key
        map.remove("Apple");

        // 5. Iterate
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
