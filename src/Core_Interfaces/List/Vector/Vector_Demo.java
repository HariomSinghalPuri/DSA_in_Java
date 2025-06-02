package Core_Interfaces.List.Vector;


import java.util.Vector;
import java.util.List;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;

//<<<---------------------------------------------------------------------------------------------------------------->>>
// How To Call Vectors in java :



public class Vector_Demo {
    public static void main(String[] args) {
        Vector<String> fruits = new Vector<>();
//<<<---------------------------------------------------------------------------------------------------------------->>>
// Adding Elements in Vector:

        // add element at end
        fruits.add("Apple");
        fruits.add("Banana");

        // add at specific index
        fruits.add(1, "Orange");

        // add element - synchronized method
        fruits.addElement("Pineapple");

        // add all elements from another collection
        List<String> moreFruits = Arrays.asList("Mango", "Grapes");
        fruits.addAll(moreFruits);

        System.out.println(fruits);
        System.out.println(moreFruits);
//<<<---------------------------------------------------------------------------------------------------------------->>>
// Accessing Elements:
//        // get element by index
//        String first = fruits.get(0);
//        String firstElement = fruits.firstElement();
//        String lastElement = fruits.lastElement();
//
//        // check if element exists
//        boolean hasApple = fruits.contains("Apple");
//
//        // get index of element
//        int index = fruits.indexOf("Banana");
//        int lastIndex = fruits.lastIndexOf("Mango");
//
//        // get size and capacity
//        int size = fruits.size();
//        int capacity = fruits.capacity();

//<<<---------------------------------------------------------------------------------------------------------------->>>
//Removing Elements :
        // remove by index
        //fruits.remove(0);

        // remove by object
        //fruits.remove("Banana");

        // remove all elements from a collection
        //fruits.removeAll(DSA_Level_1.Arrays.asList("Mango", "Grapes"));

        // remove all elements
        //fruits.clear();

        // remove element - synchronized method
        //fruits.removeElement("Pineapple");

        // remove element at index - synchronized method
        //fruits.removeElementAt(1);

        //print All Elements For Checking :
        //System.out.println(fruits);

//<<<---------------------------------------------------------------------------------------------------------------->>>
//Updating Elements :

//        // set element at index
//        // Set krne se Waha ka Value hatt jaega :
//        fruits.set(0, "Green Apple");
//
//        // synchronized version
//        fruits.setElementAt("Red Apple", 0);
//
//        // trim to current size
//        fruits.trimToSize();
//
//        //print All Elements For Checking :
//        System.out.println(fruits);

//<<<---------------------------------------------------------------------------------------------------------------->>>
// Iterating Over Vectors
// Yad Rakhna DSA_Level_1.Arrays.asList("","","") krne se directly sb List me Change ho jata haia .


        Vector<String> colors = new Vector<>(Arrays.asList("Red", "Green", "Blue"));

    // 1. Using for loop
        for (int i = 0; i < colors.size(); i++) {
            System.out.println(colors.get(i));
        }

    // 2. Using enhanced for loop
        for (String color : colors) {
            System.out.println(color);
        }





    }
}
