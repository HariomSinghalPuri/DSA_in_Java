package Core_Interfaces.Set.CopyOnWriteArraySet;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySet_Demo {
    public static void main(String[] args) {
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();

        // Add elements
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Banana"); // Duplicate, will be ignored

        System.out.println("Initial Set: " + set);

        // Iterate safely
        System.out.println("Iterating:");
        for (String fruit : set) {
            System.out.println(fruit);
        }

        // Check existence
        System.out.println("Contains Apple? " + set.contains("Apple"));

        // Remove element
        set.remove("Orange");
        System.out.println("After removing Orange: " + set);

        // Add during iteration (modification won't affect current iteration)
        Iterator<String> itr = set.iterator();
        set.add("Grapes"); // This won't show during iteration
        System.out.println("Iterating after modification:");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Final state
        System.out.println("Final Set: " + set);
    }
}
