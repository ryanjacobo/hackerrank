package interfaces;

public class Machine implements Info{
    private int id = 1;
    @Override
    public void showInfo() {
        System.out.println("Machine ID: " + id);
    }
}
