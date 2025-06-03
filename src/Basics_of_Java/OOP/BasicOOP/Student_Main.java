package Basics_of_Java.OOP.BasicOOP;

public class Student_Main {
        public static void main(String[] args) {
            // Creating an object of the Student class
            Student student1 = new Student("Hariom Singhal Puri", 21, "24MIM10035");

            // Displaying the student's information
            student1.displayStudentInfo();

            // Creating an object of the Student class
            Student student2 = new Student("Bikram Kumar",20,"24BAI10567");

            // Displaying the Student2 Information
            student2.displayStudentInfo();

            // Changing the student's name
            student1.setName("Amit Kumar");

            // Changing the Student age
            student1.setAge(19);

            // Changing Student ID
            student1.setStudentID("24MIM10055");

            // Displaying the updated student's information
            student1.displayStudentInfo();
        }
}
