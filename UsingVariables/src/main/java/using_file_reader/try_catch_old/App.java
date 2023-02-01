package using_file_reader.try_catch_old;

import java.io.*;

public class App {
    public static void main(String[] args) {
        File file = new File("test.txt");

        BufferedReader br = null; // must be initialized as null so that it can be closed (to prevent memory leak)
        try {
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: "+file.toString());
        } catch (IOException e) {
            System.out.println("Unable to read file: " + file.toString());
        }
        // always executed whether file was found or not
        finally {
            try{
                br.close();
            } catch (IOException e) {
                System.out.println("Unable to close file: " + file.toString());
            } catch(NullPointerException ex) {
                // for purposes of not being able to open the file in the first place due to mispelled file name
            }
        }
    }
}
