package interfaces;

public class Main {
    public static void main(String[] args) {
        Person guy = new Person("Kipster");

//        guy.showInfo();

        Info infoGuy = guy;
        infoGuy.showInfo();

        Info machine = new Machine();
        machine.showInfo();

        outputInfo(guy);
        outputInfo(machine);
    }

    private static void outputInfo(Info info) {
        info.showInfo();
    }
}
