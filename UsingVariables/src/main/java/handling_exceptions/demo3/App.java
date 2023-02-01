package handling_exceptions.demo3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class App {
    public static void main(String[] args) {
        try {
            openFile();
        } catch (FileNotFoundException e) {

            System.out.println("Could not open file");
        }
    }

    public static void openFile() throws FileNotFoundException {
        File file = new File("tests.txt");

        FileReader fr = new FileReader(file);
    }
}
