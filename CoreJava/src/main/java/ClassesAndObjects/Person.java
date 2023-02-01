package ClassesAndObjects;

public class Person {
        private String name;
        private int age;
        // static type variables
        private static String description;
        private final static int LUCKY_NUMBER = 24;
        private static int count = 1;
        private int id = count;
        // protected - accessible from child class
        protected String language = "English";

        // Constructors - constructors must be named same as the class name. It runs everytime an object is created.
        public Person(){
//            this("Biff", 50);
            System.out.println("Constructor running...");

            System.out.println("The number of person objects are: " + count++);
        };

        public Person(String newName, int newAge) {
            this.name =  newName;
            this.age = newAge;

            System.out.println("2nd constructor running...");
            System.out.println("The number of person objects are: " + count++);
        }

        // Methods (with parameters)
        void speak(String phrase) {
            System.out.println(phrase + " " + name + " " + age + " years old.");
        }
        void move(String direction, int distance) {
            System.out.println("Moving " + direction + ", " + distance + " meters");
        }

        void stop() {
            System.out.println("Stop moving.");
        }
        // without parameters
        void calcYearsToRetirement() {
            int yearsLeft = 65 - age;

            System.out.println("You have " + yearsLeft + " years left before retirement.");
        }

        // Return values
        int returnYearsToRetirement() {
            return 65 - age;
        }

        // Get methods(getters)
        int getAge() {
            return age;
        }

        String getName() {
            return name;
        }

        // Set methods(setters)
        void setName(String newName) {
            name = newName;
        }

        void setAge(int newAge) {
            age = newAge;
        }

        void setInfo(String name, int age) {
            setName(name);
            setAge(age);
        }

        void printPersonInfo(Person person){
            System.out.println("New person is " + person.getName() + ", " + person.getAge() + " years old. ID: " + id);
        }

        // static method - makes the method accessible to the class without creating an object.
        public static void showInfo() {
            System.out.println("I'm a static method.");
        }

        // toString method
        public String toString() {
//            StringBuilder personDetails = new StringBuilder();
//            personDetails.append("ID: ").append(id).append(", ").append("name: ").append(name).append(", ").append("age: ").append(age);
//            return personDetails.toString();
//            return "I am toString. " + "name: " + name + ", age: " + age + ", id: " + id;

            return String.format("%2d: %s, %d", id, name, age);
        }

    public static void main(String[] args) {
        // Creating an object
        Person person1 = new Person();
        person1.name = "Ryan";
        person1.age = 43;
        person1.printPersonInfo(person1);

        Person person2 = new Person();
        person2.name = "Sarah";
        person2.age = 22;
        person2.speak("Good morning, I'm ");

        System.out.println(person1.name);
        person1.speak("Hello, I'm ");
        person1.calcYearsToRetirement();
        System.out.println(person2.name + " have " + person2.returnYearsToRetirement() + " years left before retirement.");

        System.out.println(person1.getAge());
        String person1Name = person1.getName();
        System.out.println(person1Name);

        person1.move("East", 50);

        Person person3 = new Person();
        person3.setName("Marty");
        person3.setAge(30);

        System.out.println("New person's name is " + person3.getName());
        System.out.println(person3.getName() + "'s age is " + person3.getAge());
        person3.move("West", 45);

        Person person4 = new Person();
        person4.setInfo("Lloyd", 32);
        System.out.println(person4.getName());
        person4.printPersonInfo(person4);

        Person person5 = new Person("Hero", 4);
        person5.printPersonInfo(person5);

        Person.description = "I am static variable.";
        System.out.println(Person.description);

        Person.showInfo();
        System.out.println(Person.LUCKY_NUMBER);

        System.out.println("Count is at: " + Person.count);

        Person person6 = new Person("Pia", 43);
        System.out.println(person6);

        System.out.println("Count is at: " + Person.count);
        System.out.println(person1);
    }
}
