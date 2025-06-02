package Core_Interfaces.Map.ConcurrentMap.ConcurrentHashMap.ConcurrentSkipListMap;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMap_Demo {
    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();

        // 1. put()
        map.put(1, "One");
        map.put(3, "Three");
        map.put(5, "Five");
        System.out.println("Initial Map: " + map);

        // 2. get()
        System.out.println("Get 3: " + map.get(3));

        // 3. putIfAbsent()
        map.putIfAbsent(3, "Thirty"); // Won't overwrite
        map.putIfAbsent(2, "Two");
        System.out.println("After putIfAbsent: " + map);

        // 4. remove(key)
        map.remove(5);
        System.out.println("After remove: " + map);

        // 5. remove(key, value)
        map.remove(2, "Two");
        System.out.println("After conditional remove: " + map);

        // 6. replace(key, value)
        map.replace(1, "ONE");
        System.out.println("After replace: " + map);

        // 7. replace(key, oldVal, newVal)
        map.replace(1, "ONE", "Uno");
        System.out.println("After conditional replace: " + map);

        // 8. lowerKey()
        System.out.println("Lower than 3: " + map.lowerKey(3));

        // 9. higherKey()
        System.out.println("Higher than 1: " + map.higherKey(1));

        // 10. subMap()
        System.out.println("SubMap 1 to 3: " + map.subMap(1, true, 3, true));

        // 11. descendingMap()
        System.out.println("Descending Map: " + map.descendingMap());

        // 12. entrySet()
        System.out.println("Entries: " + map.entrySet());
    }
}
