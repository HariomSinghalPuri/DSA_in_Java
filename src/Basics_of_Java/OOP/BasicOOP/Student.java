package Basics_of_Java.OOP.BasicOOP;

public class Student {
            // Class properties
            private String name;
            private int age;
            private String studentID;

            // Constructor
            // Matlab koi argument aa gya hai bs.
            public Student(String name, int age, String studentID) {
                this.name = name;
                this.age = age;
                this.studentID = studentID;
            }

    // Getter methods
            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }

            public String getStudentID() {
                return studentID;
            }

            // Setter methods
            public void setName(String name) {
                this.name = name;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public void setStudentID(String studentID) {
                this.studentID = studentID;
            }

            // Method to display student details
            public void displayStudentInfo() {
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Student ID: " + studentID);
            }
}


