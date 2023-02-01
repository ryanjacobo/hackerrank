package inner_classes;

public class Robot {
    private final int id;

    public Robot(int id) {
        this.id = id;
    }

    private class Brain {
        public void think() {
            System.out.println("Robot " + id + " is thinking.");
        }
    }

    public static class Battery {
        public void charge() {
            System.out.println("Battery charging...");
        }
    }

    public void start() {
        System.out.println("Starting robot " + id);

        // Use Brain. We don't have an instance of brain
        // until we create one. Instances of brain are
        // always associated with instances of Robot (the
        // enclosing class).
        Brain brain = new Brain();
        brain.think();

        final String name = "Robert";

        // Sometimes it's useful to create local classes
        // within methods. You can use them only within the method.
        class Temp {
            public void doSomething() {
                System.out.println("ID is: " + id);
                System.out.println("My name is " + name);
            }
        }

        Temp temp = new Temp();
        temp.doSomething();
    }
}
