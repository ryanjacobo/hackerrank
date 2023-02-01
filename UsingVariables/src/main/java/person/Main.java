package person;

public class Main {
    public static void main(String[] args) {
    Person ryan = new Person("Ryan", 42);

        System.out.println(ryan);
        System.out.println(ryan.getName());
        System.out.println(ryan.getAge());
        ryan.speak();
        int years = ryan.calcYearsToRetirement();
        System.out.println("I have " + years + " years to retirement.");
        System.out.println(ryan.saySomething("Fuck off!"));
        ryan.jump(6);
        ryan.move("left", 24);
        ryan.setName("Marty");
        System.out.println(ryan.getName());
        ryan.setAge(43);
        System.out.println(ryan.getAge());
//        ryan.name = "Philip";
//        System.out.println(ryan.name);
        Person mcfly = new Person();
        mcfly.setName("Marty");
        System.out.println(mcfly.getName() + " is person object number: " + (Person.count + 1));

        String fName = mcfly.getName();
        mcfly.setAge(60);
        System.out.println("Mcfly's first name is: " + fName);
        Person jacobo = new Person();
        jacobo.setName("Joana");
        System.out.println(jacobo.getName() + " is person object number: " + (Person.count + 1));

        jacobo.setAge(24);
        System.out.println("Mrs Jacobo's first name is: " + jacobo.getName() + "\n"
        + "and she is " + jacobo.getAge() + " years old.");

        Person.description = "I am a static variable";
        System.out.println(ryan.description);

        ryan.showName();
        System.out.println(Person.count);

        StringBuilder sb = new StringBuilder();
        sb.append("My name is Sue.");
        sb.append(" ");
        sb.append("I am a lion-tamer.");
        System.out.println(sb.toString());

        sb = new StringBuilder();
        sb.append("My name is Ryan. ").append("I am a mountainbiker.");
        System.out.println(sb.toString());

        System.out.printf("Total cost %d; quantity is %d", 5 ,120); // d means a number will be assigned in the %d

        for(int i=0; i<15; i++){
            System.out.printf("%-2d: some text here\n", i); // -2 means the text is aligned on the left with 2 characters on the right
        }

        for(int i=0; i<15; i++){
            System.out.printf("%-2d: %s\n", i, "here is some text"); // s means a string will be assigned in the %s
        }

        System.out.printf("Total float value: %.2f\n", 5.6874); // .2 means the value will be rounded to two dec places
        System.out.printf("Total float value: %-6.1f\n", 343.24323); // -6.1f means the value will be aligned to the left with 1 dec place and 6 spaces to the right
        System.out.printf("Total float value: %6.1f\n", 132234312.2343);

        System.out.println(mcfly);
    }

}
