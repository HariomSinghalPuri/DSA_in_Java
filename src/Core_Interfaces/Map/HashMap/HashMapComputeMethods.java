package Core_Interfaces.Map.HashMap;
import java.util.Map;
import java.util.HashMap;


public class HashMapComputeMethods {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        System.out.println(map);

        // Compute if absent
        map.computeIfAbsent("B", k -> 2);
        System.out.println("Map After Putting Values Through map.computeOfAbsent: "+map);


        // Compute if present
        map.computeIfPresent("A", (k, v) -> v + 1);
        System.out.println(map);

        // Compute
        map.compute("C", (k, v) -> (v == null) ? 1 : v + 1);
        System.out.println(map);


    }
}
