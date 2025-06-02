package Core_Interfaces.Map.HashMap.WeakHashMap;

import java.util.WeakHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class WeakHashMap_Demo {
    public static void main(String[] args) {
        WeakHashMap<Object, String> map = new WeakHashMap<>();

        Object key1 = new String("Key1");
        Object key2 = new String("Key2");

        // 1. put()
        map.put(key1, "Value1");
        map.put(key2, "Value2");

        // 2. get()
        System.out.println("Get key1: " + map.get(key1));

        // 3. containsKey()
        System.out.println("Contains key1? " + map.containsKey(key1));

        // 4. containsValue()
        System.out.println("Contains 'Value2'? " + map.containsValue("Value2"));

        // 5. size()
        System.out.println("Map size: " + map.size());

        // 6. isEmpty()
        System.out.println("Is map empty? " + map.isEmpty());

        // 7. keySet()
        System.out.println("Keys:");
        for (Object key : map.keySet()) {
            System.out.println(key);
        }

        // 8. values()
        System.out.println("Values:");
        for (String value : map.values()) {
            System.out.println(value);
        }

        // 9. entrySet()
        System.out.println("Entries:");
        for (Map.Entry<Object, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // 10. putAll()
        Map<Object, String> anotherMap = new WeakHashMap<>();
        anotherMap.put("Key3", "Value3");
        map.putAll(anotherMap);

        // 11. remove()
        map.remove(key1);
        System.out.println("After removing key1, size: " + map.size());

        // 12. clear()
        map.clear();
        System.out.println("After clear(), is empty? " + map.isEmpty());
    }
}
