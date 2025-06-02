package Core_Interfaces.Map.HashMap;

import java.util.HashMap;

public class HashMapNullHandling {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // (1) Null key is allowed (only one)
        map.put(null, 100);
        System.out.println(map.get(null)); // 100

        // (2) Multiple null values allowed
        map.put("X", null);
        map.put("Y", null);
        System.out.println(map); // {null=100, X=null, Y=null}
    }
}
