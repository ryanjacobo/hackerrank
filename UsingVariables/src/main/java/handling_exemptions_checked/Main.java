package handling_exemptions_checked;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("examples.txt");

        FileReader fr = new FileReader(file);
    }
}
