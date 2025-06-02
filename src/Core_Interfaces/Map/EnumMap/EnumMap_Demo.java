package Core_Interfaces.Map.EnumMap;

import java.util.EnumMap;
import java.util.Map;

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
}

public class EnumMap_Demo {
    public static void main(String[] args) {
        EnumMap<Day, String> schedule = new EnumMap<>(Day.class);

        // 1. put()
        schedule.put(Day.MONDAY, "Maths");
        schedule.put(Day.TUESDAY, "Science");
        schedule.put(Day.WEDNESDAY, "History");
        System.out.println("Initial Schedule: " + schedule);

        // 2. get()
        System.out.println("Get Tuesday: " + schedule.get(Day.TUESDAY));

        // 3. putIfAbsent()
        schedule.putIfAbsent(Day.MONDAY, "English"); // Won't overwrite
        schedule.putIfAbsent(Day.THURSDAY, "English"); // Adds new
        System.out.println("After putIfAbsent: " + schedule);

        // 4. remove(key)
        schedule.remove(Day.THURSDAY);
        System.out.println("After remove: " + schedule);

        // 5. remove(key, value)
        boolean removed = schedule.remove(Day.TUESDAY, "Science");
        System.out.println("Conditional remove TUESDAY: " + removed);
        System.out.println("After conditional remove: " + schedule);

        // 6. replace(key, value)
        schedule.replace(Day.MONDAY, "Biology");
        System.out.println("After replace: " + schedule);

        // 7. replace(key, oldVal, newVal)
        schedule.replace(Day.MONDAY, "Biology", "Physics");
        System.out.println("After conditional replace: " + schedule);

        // 8. containsKey()
        System.out.println("Contains key WEDNESDAY? " + schedule.containsKey(Day.WEDNESDAY));

        // 9. containsValue()
        System.out.println("Contains value History? " + schedule.containsValue("History"));

        // 10. keySet()
        System.out.println("Keys: " + schedule.keySet());

        // 11. values()
        System.out.println("Values: " + schedule.values());

        // 12. entrySet()
        System.out.println("Entries: " + schedule.entrySet());
    }
}

