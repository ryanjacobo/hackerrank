package handling_exceptions.demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class App {
    public static void main(String[] args) {
        File file = new File("tests.txt");

        try {
            FileReader fr = new FileReader(file); // Proceeds to next line if test.txt file is present in the root directory
            System.out.println("Continuing...");
        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
            System.out.println("File not found: " + file.toString());
        }
        System.out.println("Finished"); // Shows "Finished" if the exception error was caught
    }
}
