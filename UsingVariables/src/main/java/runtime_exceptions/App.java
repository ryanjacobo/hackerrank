package runtime_exceptions;

public class App {
    public static void main(String[] args) {
        String text = null;
//        text = "hello"; // still runs but returns an error due to text being null
        System.out.println(text.length());
    }
}
