package Core_Interfaces.Set.SortedSet.NavigableSet.TreeSet;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSet_Demo {
    public static void main(String[] args) {
        NavigableSet<String> treeSet = new TreeSet<>();

        // Add elements
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Mango");
        treeSet.add("Grapes");

        System.out.println("Original TreeSet: " + treeSet);

        // Navigation methods
        System.out.println("Lower than 'Mango': " + treeSet.lower("Mango"));
        System.out.println("Floor of 'Mango': " + treeSet.floor("Mango"));
        System.out.println("Ceiling of 'Orange': " + treeSet.ceiling("Orange"));
        System.out.println("Higher than 'Apple': " + treeSet.higher("Apple"));

        // Descending set
        System.out.println("Descending View: " + treeSet.descendingSet());

        // Subsets
        System.out.println("HeadSet (to 'Mango', exclusive): " + treeSet.headSet("Mango", false));
        System.out.println("TailSet (from 'Apple', inclusive): " + treeSet.tailSet("Apple", true));
        System.out.println("SubSet from 'Apple' to 'Mango': " + treeSet.subSet("Apple", true, "Mango", false));

        // Polling elements
        System.out.println("Poll First: " + treeSet.pollFirst());
        System.out.println("Poll Last: " + treeSet.pollLast());

        System.out.println("TreeSet after polling: " + treeSet);
    }
}
