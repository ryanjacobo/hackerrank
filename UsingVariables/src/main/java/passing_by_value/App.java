package passing_by_value;

public class App {
    public static void main(String[] args) {
        App app = new App();

        app.show(7);
    }

    public void show(int value){
        System.out.println("Value is: " + value);
    }
}
