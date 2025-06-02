package Core_Interfaces.Map.ConcurrentMap.ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMap_Demo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // 1. put()
        map.put("One", 1);
        map.put("Two", 2);
        System.out.println("Initial Map: " + map);

        // 2. get()
        System.out.println("Get 'Two': " + map.get("Two"));

        // 3. putIfAbsent()
        map.putIfAbsent("One", 100); // won't overwrite
        map.putIfAbsent("Three", 3); // adds new
        System.out.println("After putIfAbsent: " + map);

        // 4. remove(key)
        map.remove("Three");
        System.out.println("After remove: " + map);

        // 5. remove(key, value)
        map.remove("Two", 2);
        System.out.println("After conditional remove: " + map);

        // 6. replace(key, newValue)
        map.replace("One", 10);
        System.out.println("After replace: " + map);

        // 7. replace(key, oldValue, newValue)
        map.replace("One", 10, 20);
        System.out.println("After conditional replace: " + map);

        // 8. computeIfAbsent()
        map.computeIfAbsent("Four", k -> 4);
        System.out.println("After computeIfAbsent: " + map);

        // 9. computeIfPresent()
        map.computeIfPresent("Four", (k, v) -> v * 10);
        System.out.println("After computeIfPresent: " + map);

        // 10. containsKey()
        System.out.println("Contains key 'Four'? " + map.containsKey("Four"));

        // 11. containsValue()
        System.out.println("Contains value 40? " + map.containsValue(40));

        // 12. entrySet()
        System.out.println("Entries: " + map.entrySet());
    }
}
