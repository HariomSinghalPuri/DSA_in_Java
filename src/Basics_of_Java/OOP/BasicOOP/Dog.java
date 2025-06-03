package Basics_of_Java.OOP.BasicOOP;

// Java Program to Demonstrate the
// use of a class with instance variable

public class Dog {
        // Instance Variables
        String name;
        String breed;
        int age;
        String color;

    // Constructor Declaration of Class
    public Dog(String name, String breed, int age, String color)
    {
            this.name = name;
            this.breed = breed;
            this.age = age;
            this.color = color;
    }

        // method 1
        public String getName() {
            return name;
        }

        // method 2
        public String getBreed() {
            return breed;
        }

        // method 3
        public int getAge() {
            return age;
        }

        // method 4
        public String getColor() {
            return color;
        }

        @Override public String toString()
        {
            return ("Name is: " + this.getName()
                    + "\nBreed:" + this.breed + "\nAge:" + this.age + "\ncolor:" + this.color);
        }

        public static void main(String[] args)
        {
            Dog Rangila = new Dog("Rangila", "GaliKaKutta", 5, "Brown");
            System.out.println(Rangila.toString());
            Dog dog2 = new Dog("Tommy","pavallion",15,"Black");
            System.out.println(dog2.toString());
        }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

}
