package enum_types;

public class App {
    public static void main(String[] args) {
        Animal animal = Animal.CAT;

        switch(animal) {
            case CAT:
                System.out.println("Cat");
                break;
            case DOG:
                System.out.println("Dog");

                break;
            case MOUSE:
                System.out.println("Mouse");

                break;
            default:
                break;
        }

        System.out.println(Animal.DOG);
        System.out.println(Animal.MOUSE.getName());
        System.out.println(Animal.DOG instanceof Enum);

        System.out.println(Animal.valueOf("CAT"));
    }


}
