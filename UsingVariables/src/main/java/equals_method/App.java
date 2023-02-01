package equals_method;

public class App {
    public static void main(String[] args) {
        Person person1 = new Person(1, "Ryan");
        Person person2 = new Person(1, "Kipster");

        // using equals method to compare objects (by Id)
        System.out.println(person1.equals(person2));

        // comparing int's and doubles using "=="
        double value1 = 7.2;
        double value2 = 7.2;
        System.out.println(value1==value2);


        int num1 = 7;
        int num2 = 7;
        System.out.println(num1==num2);

        String text1 = "Hello";
        String text2 = "Hellofadf".substring(0,6); // 0 = start of the string, 6 = number of substrings
        System.out.println(text2);
        System.out.println(text1==text2);

    }
}

