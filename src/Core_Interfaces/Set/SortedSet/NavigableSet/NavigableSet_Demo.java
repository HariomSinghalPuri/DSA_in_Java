package Core_Interfaces.Set.SortedSet.NavigableSet;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSet_Demo {
    public static void main(String[] args) {
        NavigableSet<Integer> navSet = new TreeSet<>();

        // Add elements
        navSet.add(10);
        navSet.add(20);
        navSet.add(30);
        navSet.add(40);
        navSet.add(50);

        System.out.println("Original NavigableSet: " + navSet);

        // Navigation methods
        System.out.println("Lower than 30: " + navSet.lower(30));    // 20
        System.out.println("Floor of 30: " + navSet.floor(30));      // 30
        System.out.println("Ceiling of 25: " + navSet.ceiling(25));  // 30
        System.out.println("Higher than 30: " + navSet.higher(30));  // 40

        // Descending view
        System.out.println("Descending Set: " + navSet.descendingSet());

        // Subsets
        System.out.println("HeadSet (exclusive 40): " + navSet.headSet(40, false));
        System.out.println("TailSet (inclusive 30): " + navSet.tailSet(30, true));
        System.out.println("SubSet (20,50): " + navSet.subSet(20, true, 50, false));

        // Polling methods
        System.out.println("Poll First: " + navSet.pollFirst()); // 10
        System.out.println("Poll Last: " + navSet.pollLast());   // 50

        System.out.println("Set after polling: " + navSet);
    }
}
