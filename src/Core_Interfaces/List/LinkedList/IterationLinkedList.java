package Core_Interfaces.List.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IterationLinkedList {
    public static void main(String[] args) {

//--> Iterating Over LinkedList
        LinkedList<String> colors = new LinkedList<>(List.of("Red", "Green", "Blue"));

        // 1. For Loop
        for (int i = 0; i < colors.size(); i++) {
            System.out.println(colors.get(i));
        }

        // 2. Enhanced For Loop
        for (String color : colors) {
            System.out.println(color);
        }

        // 3. Iterator
        Iterator<String> it = colors.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
