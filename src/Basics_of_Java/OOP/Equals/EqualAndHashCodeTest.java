package Basics_of_Java.OOP.Equals;

public class EqualAndHashCodeTest {
        public static void main(String[] args) {
            Person person1 = new Person("Hariom", 21, "001");
            Person person2 = new Person("Hariom", 21, "001");


            if (person1.equals(person2)) {
                System.out.println("Equals");
            } else {
                System.out.println("Not equal");
            }
        }
}
