package Core_Interfaces.Set.SortedSet;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSet_Demo {
    public static void main(String[] args) {
        // Create a SortedSet (TreeSet implementation)
        SortedSet<Integer> numbers = new TreeSet<>();

        // Add elements
        numbers.add(50);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);
        numbers.add(40);

        System.out.println("SortedSet: " + numbers);

        // Access first and last elements
        System.out.println("First Element: " + numbers.first());
        System.out.println("Last Element: " + numbers.last());

        // Subsets
        System.out.println("HeadSet (<30): " + numbers.headSet(30));
        System.out.println("TailSet (>=30): " + numbers.tailSet(30));
        System.out.println("SubSet (20 to 40): " + numbers.subSet(20, 40));

        // Remove an element
        numbers.remove(10);
        System.out.println("After removing 10: " + numbers);
    }
}
