/**
* @author Fabian Schilling (fabsch@kth.se)
*/


public class Main {

    public static IO io = new IO(System.in, System.out);

    public static void main(String[] args) {

        String word = io.getWord();
        String pat = io.getWord();

        while (word.contains(pat)) {
             word = word.replace(pat, "");
        }

        if (word.equals("")) {
            io.println("FRULA");
        } else {
            io.println(word);
        }

        io.close();
    }
}