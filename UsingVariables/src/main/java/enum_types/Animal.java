package enum_types;

public enum Animal {
    DOG("Fido"), CAT("Fergus"), MOUSE("Jerry"), DEER("Bambi"), RACOON("Rocket");
    private String name;

    Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "This animal is called: " + name;
    }
}
