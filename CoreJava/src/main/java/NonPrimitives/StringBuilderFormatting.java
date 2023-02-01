package NonPrimitives;

public class StringBuilderFormatting {
    public static void main(String[] args) {
        // Without StringBuilder
        String info = "";
        String space = " ";

        info += "Hello" + space;
        info += "what's" + space;
        info += "up" +space ;
        info += "?";

        System.out.println(info);

        // Using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("Hello!");
        sb.append(" ");
        sb.append("What's up?").append(" Bye!");
        System.out.println(sb.toString());

        StringBuilder sb2 = new StringBuilder();
        sb2.append("Where you going?").append(" Wanna hangout?");
        System.out.println(sb2.toString());

        // Using parameters to fill values in a String.
        System.out.printf("My age next year is: %d and my salary will be $%d.", 44, 100000);
        System.out.println("\n");
        for(int i=0; i<20; i++){
            System.out.printf("%2d: numbering using parameter \n", i ); // "2" is the width of the left side of the ":"
        }

        System.out.printf("Total value: %.2f\n", 6.789); // ".2" is the number of decimal points
        System.out.printf("%6.2f: 6 spaces on the left with 2 decimals places\n", 6.789); // ".2" is the number of decimal points
        System.out.printf("%-6.2f: 6 spaces on the right with 2 decimals places", 6.789); // ".2" is the number of decimal points
    }
}
