package Core_Interfaces.Set.EnumSet;

import java.util.EnumSet;
import java.util.Set;

// Define an enum
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumSet_Demo {
    public static void main(String[] args) {
        // Create a set with specific days
        EnumSet<Day> workDays = EnumSet.of(Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY);
        System.out.println("Work Days: " + workDays);

        // Add another element
        workDays.add(Day.SATURDAY);
        System.out.println("Work Days (after adding Saturday): " + workDays);

        // Create an empty set and add all
        EnumSet<Day> weekend = EnumSet.noneOf(Day.class);
        weekend.add(Day.SATURDAY);
        weekend.add(Day.SUNDAY);
        System.out.println("Weekend: " + weekend);

        // All days
        EnumSet<Day> allDays = EnumSet.allOf(Day.class);
        System.out.println("All Days: " + allDays);

        // Complement of workDays
        EnumSet<Day> holidays = EnumSet.complementOf(workDays);
        System.out.println("Holidays: " + holidays);

        // Range
        EnumSet<Day> midWeek = EnumSet.range(Day.TUESDAY, Day.THURSDAY);
        System.out.println("Midweek Days: " + midWeek);

        // Remove element
        workDays.remove(Day.MONDAY);
        System.out.println("Work Days (after removing Monday): " + workDays);

        // Contains
        System.out.println("Does Work Days contain FRIDAY? " + workDays.contains(Day.FRIDAY));
    }
}
