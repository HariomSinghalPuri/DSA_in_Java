package Core_Interfaces.Map.SortedMap.TreeMap;

import java.util.TreeMap;
import java.util.SortedMap;

public class TreeMap_Demo {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // 1. put()
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");

        // 2. get()
        System.out.println("Get key 2: " + treeMap.get(2)); // Two

        // 3. remove()
        treeMap.remove(3);
        System.out.println("After removing key 3: " + treeMap);

        // 4. containsKey()
        System.out.println("Contains key 1? " + treeMap.containsKey(1)); // true

        // 5. containsValue()
        System.out.println("Contains value 'Two'? " + treeMap.containsValue("Two")); // true

        // 6. size()
        System.out.println("Size: " + treeMap.size());

        // 7. isEmpty()
        System.out.println("Is map empty? " + treeMap.isEmpty());

        // 8. keySet()
        System.out.println("Keys: " + treeMap.keySet());

        // 9. values()
        System.out.println("Values: " + treeMap.values());

        // 10. entrySet()
        System.out.println("Entries: " + treeMap.entrySet());

        // 11. firstKey()
        System.out.println("First key: " + treeMap.firstKey());

        // 12. lastKey()
        System.out.println("Last key: " + treeMap.lastKey());

        // 13. headMap()
        SortedMap<Integer, String> head = treeMap.headMap(2);
        System.out.println("Head map (keys < 2): " + head);

        // 14. tailMap()
        SortedMap<Integer, String> tail = treeMap.tailMap(2);
        System.out.println("Tail map (keys >= 2): " + tail);

        // 15. subMap()
        SortedMap<Integer, String> sub = treeMap.subMap(1, 3);
        System.out.println("Sub map (1 <= key < 3): " + sub);
    }
}
