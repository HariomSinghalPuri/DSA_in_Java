package Core_Interfaces.Map.HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasicOperation {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        //----->Basic Operations :

        // Adding elements
        map.put("Hariom Puri", "6410");
        map.put("Singhal Puri", "1021");
        System.out.println(map);


        // Retrieving elements
        String v1 = map.get("Hariom Puri");
        System.out.println("Key Value of Hariom Puri is :"+v1);

        // Checking if key or value exists
        boolean hasKey = map.containsKey("Hariom Puri");
        System.out.println("Is key Hariom Puri is in Map :"+hasKey);

        boolean hasValue = map.containsValue("6410");
        System.out.println("Is Value 6410 is in Map :"+hasValue);

        // Removing elements
        map.remove("Singhal Puri");
        System.out.println("Map After Removing key String: "+ map);

        // Adding Elements
        map.put("Singhal Puri","1122");
        System.out.println("Map After Adding key String and Value String: "+ map);

        // Getting size
        int size = map.size();
        System.out.println("Size of The Map is: "+ size);

        // Clearing the map
        map.clear();
        System.out.println("Map After using map.clear: "+ map);

        // Checking if empty
        boolean isEmpty = map.isEmpty();
        System.out.println("Is Map is Empty: "+ isEmpty);








    }
}
