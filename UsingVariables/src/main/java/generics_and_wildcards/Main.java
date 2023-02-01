package generics_and_wildcards;

import java.util.ArrayList;

class Machine {
    public String toString(){
        return "I am a machine";
    }
    public void start(){
        System.out.println("Machine starting...");
    }
}

class Camera extends Machine{
    public String toString() {
        return "I am a camera";
    }
    public void snap(){
        System.out.println("Taking an picture...");
    }
}
public class Main {
    public static void main(String[] args) {
        ArrayList<String> numbers = new ArrayList<>();

        numbers.add("one");
        numbers.add("two");
        numbers.add("three");

        showList(numbers);

        ArrayList<Machine> machine = new ArrayList<Machine>();
        machine.add(new Machine());
        machine.add(new Machine());

        showList(machine);

        ArrayList<Camera> camera = new ArrayList<Camera>();
        camera.add(new Camera());
        camera.add(new Camera());

        showList(camera);
    }

    // <?> is a wildcard meaning you can use any Object that was created
    public static void showList(ArrayList<?> list){
        for(Object value: list){
            System.out.println(value);
//            value.start();
        }
    }
}
