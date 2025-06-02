package Core_Interfaces.Map.HashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ThreadSafeHashMap {
    public static void main(String[] args) {

        // (1) Using Collections.synchronizedMap()
        Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());

        // (2) Using ConcurrentHashMap (Better for high concurrency)
        Map<String, Integer> concurrentMap = new java.util.concurrent.ConcurrentHashMap<>();
    }
}