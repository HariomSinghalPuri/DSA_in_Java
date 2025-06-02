package Core_Interfaces.Set.HashSet.LinkedHashSet;

import java.util.LinkedHashSet;

public class LinkedHashSet_Demo {
    public static void main(String[] args) {
        // Create a LinkedHashSet of strings
        LinkedHashSet<String> colors = new LinkedHashSet<>();

        // Add elements
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Green"); // Duplicate - ignored
        colors.add(null);    // One null allowed

        System.out.println("Initial Set: " + colors);

        // Check existence
        System.out.println("Contains Blue? " + colors.contains("Blue"));
        System.out.println("Contains Yellow? " + colors.contains("Yellow"));

        // Remove an element
        colors.remove("Red");
        System.out.println("After removing Red: " + colors);

        // Size of the set
        System.out.println("Size: " + colors.size());

        // Iterate
        for (String color : colors) {
            System.out.println("Color: " + color);
        }

        // Clear set
        colors.clear();
        System.out.println("Is set empty? " + colors.isEmpty());
    }
}
