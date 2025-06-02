package Core_Interfaces.Map.HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapMerge {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        // Merge: If key exists, combine old & new value
        map.merge("A", 10, (oldValue, newValue) -> oldValue + newValue); // A=11
        map.merge("C", 5, (oldValue, newValue) -> oldValue + newValue);  // C=5 (added)

        System.out.println(map); // {A=11, B=2, C=5}
    }
}
