package Core_Interfaces.Set.HashSet;

import java.util.HashSet;

public class HashSet_Demo {
    public static void main(String[] args) {
        // Create a HashSet of strings
        HashSet<String> fruits = new HashSet<>();

        // Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Banana"); // Duplicate - will be ignored
        fruits.add(null);     // One null allowed

        System.out.println("Fruits Set: " + fruits);

        // Check existence
        System.out.println("Contains Mango? " + fruits.contains("Mango"));
        System.out.println("Contains Grapes? " + fruits.contains("Grapes"));

        // Remove an element
        fruits.remove("Apple");
        System.out.println("After removing Apple: " + fruits);

        // Size of the set
        System.out.println("Size: " + fruits.size());

        // Iterate through set
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }

        // Clear all elements
        fruits.clear();
        System.out.println("Is set empty? " + fruits.isEmpty());
    }
}
