package machine;

public class Main {
    public static void main(String[] args) {
        Machine machOne = new Machine();
        machOne.start("Generator");
        machOne.stop("Refrigerator");

        Car carOne = new Car();
        carOne.start("Car");
        carOne.stop("Auto");

        carOne.showInfo();
    }
}
