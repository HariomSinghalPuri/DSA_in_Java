package Core_Interfaces.List.LinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;

import static java.lang.System.in;
import static java.lang.System.out;


public class LinkedList_Demo {
    public static void main(String[] args) {
//--> Creating a LinkedList

        // 1. Default LinkedList (Doubly LinkedList)
       LinkedList<String> names = new LinkedList<>();

        // 2. LinkedList from another collection
//      List<Integer> numbers = List.of(10, 20, 30);
//      LinkedList<Integer> NumLinkedList = new LinkedList<>(numbers);

//<<<---------------------------------------------------------------------------------------------------------------->>>

//--> 1. Adding Elements
        LinkedList<String> fruits = new LinkedList<>();

        // Add at the end
        fruits.add("Apple");
        fruits.addLast("Banana"); // Same as add()

        // Add at the beginning
        fruits.addFirst("Mango");

        // Add at specific index
        fruits.add(1, "Orange");

        // Display All Fruits :
        System.out.println("List of Fruits are:" + fruits);

        // Add all from another collection
        List<String> moreFruits = List.of("Grapes", "Pineapple");
        fruits.addAll(moreFruits);
        System.out.println("List of Fruits add using List.of are : "+moreFruits);

//<<<---------------------------------------------------------------------------------------------------------------->>>

//--> 2. Accessing Elements
        // Get first & last element
//        String first = fruits.getFirst();
//        String last = fruits.getLast();
//        System.out.println("First Fruit is : "+first);
//        System.out.println("Last Fruit is : "+last);
//
//        // Get by index
//        String fruit = fruits.get(2);
//        System.out.println("Fruit at Index 2 is : "+fruit);
//
//        // Check if element exists
//        boolean hasApple = fruits.contains("Apple");
//        System.out.println("Is Apple is in The List : "+hasApple);
//
//        // Find index of element
//        int index = fruits.indexOf("Banana");
//        System.out.println("Index of Fruit Banana is : "+index);

//<<<---------------------------------------------------------------------------------------------------------------->>>

//-->3. Removing Elements

//        // Displaying All Fruits :
//        System.out.println("List Of All Fruits are : "+fruits);
//
//        // Remove first element
//        fruits.removeFirst(); // OR fruits.poll()
//        System.out.println("List After Removing First Fruit  : "+fruits);
//
//        // Remove last element
//        fruits.removeLast(); // OR fruits.pollLast()
//        System.out.println("List After Removing Last Fruit : "+fruits);
//
//        // Remove by object
//        fruits.remove("Banana");
//        System.out.println("List After Removing Fruit Banana : "+fruits);
//
//        // Remove by index
//        fruits.remove(1);
//        System.out.println("List After Removing Fruit At index 1 : "+fruits);
//
//        // Clear all elements
//        fruits.clear();
//        System.out.println("List after Clear All : "+ fruits);

//<<<---------------------------------------------------------------------------------------------------------------->>>
//-->Update Elements :

        fruits.set(0, "Green Apple");
        System.out.println("List after Setting Green Apple at Index 0 : "+ fruits);

        // Replace all elements (Java 8+)
        fruits.replaceAll(fruit -> fruit.toUpperCase());
        System.out.println(fruits);



    }
}
