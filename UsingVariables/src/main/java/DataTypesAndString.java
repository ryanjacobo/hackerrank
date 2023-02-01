public class DataTypesAndString {
    public static void main(String[] args) {
        int myNumber; // declaration
        myNumber = 88; // initialization
        long myLong = 9797;
        double myDouble = 7.3242;
        float myFloat = 324.3f;
        char myChar = 'y';
        boolean myBoolean = true;
        byte myByte = 127;

        // String is a class (not primitive)
        String text = "Hello"; // Hello is an object
        String name = "Ryan";
        String space = " ";
        String punctuation = "!";
        String greeting = text + space + name + punctuation;

        System.out.println(myLong);
        System.out.println(myFloat);
        System.out.println(myChar);
        System.out.println(myBoolean);
        System.out.println(myByte);
        System.out.println(greeting);
    }
}
