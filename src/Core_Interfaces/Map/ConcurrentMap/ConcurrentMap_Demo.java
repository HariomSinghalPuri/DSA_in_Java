package Core_Interfaces.Map.ConcurrentMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMap_Demo {
    public static void main(String[] args) {
        ConcurrentMap<String, Integer> cmap = new ConcurrentHashMap<>();

        // 1. put()
        cmap.put("A", 1);
        cmap.put("B", 2);
        System.out.println("Map: " + cmap);

        // 2. get()
        System.out.println("Get B: " + cmap.get("B"));

        // 3. putIfAbsent()
        cmap.putIfAbsent("A", 100); // Won't replace
        cmap.putIfAbsent("C", 3);   // Adds new
        System.out.println("After putIfAbsent: " + cmap);

        // 4. remove(key)
        cmap.remove("C");
        System.out.println("After remove(C): " + cmap);

        // 5. remove(key, value)
        boolean removed = cmap.remove("B", 2); // Only removes if value matches
        System.out.println("Remove B if 2: " + removed);
        System.out.println("After conditional remove: " + cmap);

        // 6. replace(key, newValue)
        cmap.replace("A", 10);
        System.out.println("After replace A with 10: " + cmap);

        // 7. replace(key, oldValue, newValue)
        boolean replaced = cmap.replace("A", 10, 20);
        System.out.println("Conditional replace A 10->20: " + replaced);
        System.out.println("After conditional replace: " + cmap);

        // 8. containsKey()
        System.out.println("Contains key A? " + cmap.containsKey("A"));

        // 9. containsValue()
        System.out.println("Contains value 20? " + cmap.containsValue(20));

        // 10. keySet()
        System.out.println("Keys: " + cmap.keySet());

        // 11. values()
        System.out.println("Values: " + cmap.values());

        // 12. entrySet()
        System.out.println("Entries: " + cmap.entrySet());
    }
}
