package Core_Interfaces.Set;

import java.util.*;

public class Set_Demo {
    public static void main(String[] args) {
        // 1. Create a Set (HashSet is the most common implementation)
        Set<String> fruits = new HashSet<>();

        // 2. add(E e) – Adds an element (ignores duplicates)
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // Duplicate (ignored)
        System.out.println("Set after add(): " + fruits); // [Apple, Banana, Orange]

        // 3. contains(Object o) – Checks if an element exists
        boolean hasBanana = fruits.contains("Banana");
        System.out.println("Contains Banana? " + hasBanana); // true

        // 4. remove(Object o) – Removes an element
        fruits.remove("Orange");
        System.out.println("Set after remove(): " + fruits); // [Apple, Banana]

        // 5. size() – Returns the number of elements
        System.out.println("Size of Set: " + fruits.size()); // 2

        // 6. isEmpty() – Checks if the Set is empty
        System.out.println("Is Set empty? " + fruits.isEmpty()); // false

        // 7. clear() – Removes all elements
        fruits.clear();
        System.out.println("Set after clear(): " + fruits); // []

        // 8. Iterating over a Set (using for-each)
        fruits.add("Mango");
        fruits.add("Pineapple");
        System.out.print("Iterating Set: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " "); // Mango Pineapple
        }
    }
}
