package machine;

public class Machine {

    protected String description = "Gas Powered"; // protected can only be accessed by a class that extends the parent class
    public void start(String type) {
        System.out.println(type + " started...");
    }

    public void stop(String type) {
        System.out.println(type + " stopped...");
    }
}
