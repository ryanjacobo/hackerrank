package using_file_reader.try_catch_new;

import java.io.*;

public class App2 {
    public static void main(String[] args) {
        File file = new File("test.txt");
        // no need to use "finally" anymore
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;

            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
