package using_file_reader.try_catch_new;

public class App {
    public static void main(String[] args) {
        try(Temp temp = new Temp()) {
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}

// Will always close the object that it instantiated
class Temp implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("Closing!");

    }
}
