package Core_Interfaces.Map.HashMap.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        // 1. put(K key, V value)
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(1, "Avocado"); // Updates value for key 1
        System.out.println("After put: " + map);

        // 2. get(Object key)
        System.out.println("Get key 2: " + map.get(2));
        System.out.println("Get key 3 (not exist): " + map.get(3));

        // 3. remove(Object key)
        map.remove(1);
        System.out.println("After remove key 1: " + map);

        // 4. containsKey(Object key)
        System.out.println("Contains key 2? " + map.containsKey(2));

        // 5. containsValue(Object value)
        System.out.println("Contains value 'Banana'? " + map.containsValue("Banana"));

        // 6. size()
        System.out.println("Size: " + map.size());

        // 7. isEmpty()
        System.out.println("Is empty? " + map.isEmpty());

        // 8. clear()
        map.clear();
        System.out.println("After clear: " + map);

        // Add values again for next methods
        map.put(1, "Red");
        map.put(2, "Green");

        // 9. keySet()
        System.out.println("Key Set: " + map.keySet());

        // 10. values()
        System.out.println("Values: " + map.values());

        // 11. entrySet()
        System.out.println("Entry Set:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // 12. replace(K key, V value)
        map.replace(1, "Blue");
        System.out.println("After replace key 1: " + map);

        // 13. putIfAbsent(K key, V value)
        map.putIfAbsent(2, "Yellow");
        map.putIfAbsent(3, "Yellow");
        System.out.println("After putIfAbsent: " + map);

        // 14. clone()
        LinkedHashMap<Integer, String> cloned = (LinkedHashMap<Integer, String>) map.clone();
        System.out.println("Cloned map: " + cloned);

        // 15. forEach(BiConsumer)
        System.out.println("Using forEach:");
        map.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}

