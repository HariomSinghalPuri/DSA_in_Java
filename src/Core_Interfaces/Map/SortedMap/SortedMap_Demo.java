package Core_Interfaces.Map.SortedMap;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMap_Demo {
    public static void main(String[] args) {
        SortedMap<Integer, String> sortedMap = new TreeMap<>();

        // 1. put()
        sortedMap.put(3, "Three");
        sortedMap.put(1, "One");
        sortedMap.put(2, "Two");

        // 2. get()
        System.out.println("Get key 2: " + sortedMap.get(2)); // Two

        // 3. remove()
        sortedMap.remove(3);
        System.out.println("After removing key 3: " + sortedMap);

        // 4. containsKey()
        System.out.println("Contains key 1? " + sortedMap.containsKey(1)); // true

        // 5. containsValue()
        System.out.println("Contains value 'Two'? " + sortedMap.containsValue("Two")); // true

        // 6. size()
        System.out.println("Size: " + sortedMap.size());

        // 7. isEmpty()
        System.out.println("Is map empty? " + sortedMap.isEmpty());

        // 8. keySet()
        System.out.println("Keys: " + sortedMap.keySet());

        // 9. values()
        System.out.println("Values: " + sortedMap.values());

        // 10. entrySet()
        System.out.println("Entries: " + sortedMap.entrySet());

        // 11. firstKey()
        System.out.println("First key: " + sortedMap.firstKey());

        // 12. lastKey()
        System.out.println("Last key: " + sortedMap.lastKey());

        // 13. headMap()
        System.out.println("Head map (keys < 2): " + sortedMap.headMap(2));

        // 14. tailMap()
        System.out.println("Tail map (keys >= 2): " + sortedMap.tailMap(2));

        // 15. subMap()
        System.out.println("Sub map (1 <= key < 3): " + sortedMap.subMap(1, 3));
    }
}
