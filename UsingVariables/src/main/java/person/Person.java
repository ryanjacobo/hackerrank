package person;

public class Person {
    private String name; // private is encapsulation
    private int age;

    public static String description;

    public static int count = 0;

    // Constructor - what creates an object
    public Person() {
//        name = "George";
        count++;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name; // this.name points to the instance variable and name is the parameter.
        this.age = age;
    }

    public void showName(){
        System.out.println(description + ": " + name);
    }

    @Override
    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';

        return String.format("%s: %d yrs old", name, age);
    }

    public void speak(){
        System.out.println("My name is " + name + " and I'm " + age + " yrs old.");
    }

    public void sayHello(){
        System.out.println("Hello!");
    }

    public String saySomething(String something){
        return "Hi there! " + something;
    }

    public int jump(int height){
        System.out.println("Jump " + height + " feet.");
        return height;
    }

    public void move(String direction, double distance){
        System.out.println("Move " + distance + " feet to your " + direction);
    }
    public int calcYearsToRetirement() {
        int yearsLeft = 65 - age;

        return yearsLeft;
    }

    // getters and setters - to access the fields while keep them private
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
