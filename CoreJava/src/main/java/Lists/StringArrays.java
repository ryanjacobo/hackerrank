package Lists;

public class StringArrays {
    public static void main(String[] args) {
        String[] words = new String[3];

        words[0] = "Hello";
        words[1] = "My";
        words[2] = "Dear";

        for(String word: words) {
            System.out.print(word + " ");
        }
    }
}
