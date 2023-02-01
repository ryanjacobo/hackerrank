package polymorphism;

public class Main {
    public static void main(String[] args) {
        Plant plant = new Plant();
        Tree tree = new Tree();

        Plant plant2 = tree;
        plant2.grow();

        tree.shedLeaves();

        doGrow(tree); // polymorphism allows the child to use a method where a parent object is used.
    }

    public static void doGrow(Plant plant){
        plant.grow();
    }
}
