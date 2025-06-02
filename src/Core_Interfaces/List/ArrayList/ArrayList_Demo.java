package Core_Interfaces.List.ArrayList;

import java.util.ArrayList;

public class ArrayList_Demo {
    public static void main(String[] args) {

        // Use java.util.ArrayList instead of ArrayList_Demo
        ArrayList<String> fruits = new ArrayList<>();

        // Adding Elements One by One:
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        // Prints in format: [Apple, Banana, Orange]
        System.out.println(fruits);

        // Knowing index using index method we can also use LastIndexOf :
        System.out.println(fruits.indexOf("Apple"));
        System.out.println(fruits.lastIndexOf("Orange"));

        // Add at specific index
        fruits.add(1, "Grapes");  // Changed from "Orange" to "Grapes" for demonstration
        System.out.println(fruits);

        // Accessing elements (get method)
        System.out.println("First Element: " + fruits.get(0));

        // Updating an element (set method)
        fruits.set(1, "Blueberry");
        System.out.println("After update: " + fruits);

        // Removing an element (remove method)
        fruits.remove("Cherry");
        System.out.println("After removal: " + fruits);

        // Checking if an element exists (contains method)
        System.out.println("Contains 'Apple'? " + fruits.contains("Apple"));

        // Finding the size of the list (size method)
        System.out.println("Size of the List: " + fruits.size());

        // Iterating through the list (using a for loop)
        System.out.println("Iterating with a for loop:");
        for (String item : fruits) {
            System.out.println(item);
        }

        // Clearing all elements (clear method)
        fruits.clear();
        System.out.println("List after clear: " + fruits);

        // Checking if the list is empty (isEmpty method)
        System.out.println("Is the list empty? " + fruits.isEmpty());


    }
}