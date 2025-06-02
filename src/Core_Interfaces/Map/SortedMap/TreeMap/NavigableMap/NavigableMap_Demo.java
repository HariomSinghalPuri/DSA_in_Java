package Core_Interfaces.Map.SortedMap.TreeMap.NavigableMap;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMap_Demo {
    public static void main(String[] args) {
        NavigableMap<Integer, String> navMap = new TreeMap<>();

        navMap.put(1, "One");
        navMap.put(3, "Three");
        navMap.put(5, "Five");
        navMap.put(7, "Seven");

        // 1. lowerKey()
        System.out.println("Lower than 5: " + navMap.lowerKey(5)); // 3

        // 2. floorKey()
        System.out.println("Floor of 5: " + navMap.floorKey(5)); // 5

        // 3. ceilingKey()
        System.out.println("Ceiling of 4: " + navMap.ceilingKey(4)); // 5

        // 4. higherKey()
        System.out.println("Higher than 5: " + navMap.higherKey(5)); // 7

        // 5. pollFirstEntry()
        System.out.println("Poll First: " + navMap.pollFirstEntry()); // 1=One

        // 6. pollLastEntry()
        System.out.println("Poll Last: " + navMap.pollLastEntry()); // 7=Seven

        // 7. descendingMap()
        System.out.println("Descending Map: " + navMap.descendingMap());

        // 8. descendingKeySet()
        System.out.println("Descending Keys: " + navMap.descendingKeySet());

        // 9. subMap()
        System.out.println("SubMap(3, true, 7, false): " + navMap.subMap(3, true, 7, false));

        // 10. headMap()
        System.out.println("HeadMap(5, true): " + navMap.headMap(5, true));

        // 11. tailMap()
        System.out.println("TailMap(3, false): " + navMap.tailMap(3, false));

        // 12. keySet()
        System.out.println("Remaining Keys: " + navMap.keySet());
    }
}

