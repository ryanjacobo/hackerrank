package interfaces;

public class Person implements Info{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void showInfo(){
        System.out.println("Person name is: " + name);
    }


}
