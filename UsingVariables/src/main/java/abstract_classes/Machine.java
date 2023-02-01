package abstract_classes; // Machine is an Abstract class since it's only used as base and doesn't create objects
public abstract class Machine {
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void start();
    public abstract void doStuff();
    public abstract void shutdown();

    public void run() {
        start();
        doStuff();
        shutdown();
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
