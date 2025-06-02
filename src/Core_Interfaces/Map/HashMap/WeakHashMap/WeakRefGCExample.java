package Core_Interfaces.Map.HashMap.WeakHashMap;

import java.util.WeakHashMap;

public class WeakRefGCExample {
    public static void main(String[] args) {
        WeakHashMap<Object, String> map = new WeakHashMap<>();

        Object key = new String("TempKey");
        map.put(key, "Temporary Value");

        System.out.println("Before GC: " + map);

        key = null; // Remove strong reference
        System.gc(); // Suggest garbage collection

        try { Thread.sleep(1000); } catch (Exception ignored) {}

        System.out.println("After GC: " + map); // Entry likely removed
    }
}
