package machine;

public class Car extends Machine{

    @Override
    public void start(String type) {
        super.start(type);
    }

    @Override
    public void stop(String type) {
        super.stop(type);
    }

    public void showInfo() {
        System.out.println("Car description: " + description);
    }
}
