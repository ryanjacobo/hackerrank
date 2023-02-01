package abstract_classes;

public class App {
    public static void main(String[] args) {
        Camera cam1 = new Camera("Nikon");
        cam1.setId(1);
        System.out.println(cam1);
        cam1.run();

        Car car1 = new Car();
        car1.setId(1);
        car1.setName("Tacoma");
        System.out.println(car1);

    }

}
