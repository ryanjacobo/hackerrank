package ClassesAndObjects;

// Inheritance: WebDeveloper extends Person
public class WebDeveloper extends Person{
    public void rightCodes(){
        System.out.println("Create backend Java program.");
    }

    // overriding the method in the parent class
    public void move(String direction, int distance) {
        System.out.println("Go to your computer.");
    }

    public void showLanguage(){
        System.out.println("Language spoken: " + language);
    }

}
