package Core_Interfaces.Map.HashMap.IdentityHashMap;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class IdentityHashMap_Demo {
    public static void main(String[] args) {
        // Creating IdentityHashMap
        IdentityHashMap<String, String> map = new IdentityHashMap<>();

        // Two different String objects with the same content
        String key1 = new String("Key");
        String key2 = new String("Key");

        // 1. put()
        map.put(key1, "Value1");
        map.put(key2, "Value2"); // Different object, treated as different key

        // 2. size()
        System.out.println("Size after put(): " + map.size()); // 2

        // 3. get()
        System.out.println("Get key1: " + map.get(key1)); // Value1
        System.out.println("Get key2: " + map.get(key2)); // Value2

        // 4. containsKey()
        System.out.println("Contains key1? " + map.containsKey(key1)); // true

        // 5. containsValue()
        System.out.println("Contains value 'Value1'? " + map.containsValue("Value1")); // true

        // 6. remove()
        map.remove(key1);
        System.out.println("Size after remove(): " + map.size()); // 1

        // 7. isEmpty()
        System.out.println("Is map empty? " + map.isEmpty()); // false

        // 8. keySet()
        Set<String> keys = map.keySet();
        System.out.println("Keys in map:");
        for (String key : keys) {
            System.out.println(key);
        }

        // 9. values()
        Collection<String> values = map.values();
        System.out.println("Values in map:");
        for (String value : values) {
            System.out.println(value);
        }

        // 10. entrySet()
        Set<Map.Entry<String, String>> entries = map.entrySet();
        System.out.println("Entries in map:");
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // 11. putAll()
        IdentityHashMap<String, String> anotherMap = new IdentityHashMap<>();
        anotherMap.put("NewKey1", "NewValue1");
        anotherMap.put("NewKey2", "NewValue2");

        map.putAll(anotherMap);
        System.out.println("After putAll(): " + map);

        // 12. clear()
        map.clear();
        System.out.println("After clear(), is map empty? " + map.isEmpty()); // true
    }
}
