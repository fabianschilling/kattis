/**
* @author Fabian Schilling (fabsch@kth.se) and Hugo Sandelius (hugosa@kth.se)
*/

public class Main {

    public static IO io = new IO(System.in, System.out);

    public static void main(String[] args) {

        int n = io.getInt();

        for (int i = 0; i < n; i++) {

            Rational x = new Rational(io.getLong(), io.getLong());
            String op = io.getWord();
            Rational y = new Rational(io.getLong(), io.getLong());

            switch (op) {
                case "+":
                    io.println(x.add(y));
                    break;
                case "-":
                    io.println(x.subtract(y));
                    break;
                case "/":
                    io.println(x.divide(y));
                    break;
                case "*":
                    io.println(x.multiply(y));
                    break;
            }

        }

        io.close();
    }
}
