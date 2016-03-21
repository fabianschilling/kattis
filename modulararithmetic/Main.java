/**
* @author Fabian Schilling (fabsch@kth.se) and Hugo Sandelius (hugosa@kth.se)
*/

public class Main {

    public static IO io = new IO(System.in, System.out);
    public static void main(String[] args) {

        while (io.hasMoreTokens()) {
            long n = io.getLong();
            long t = io.getLong();
            if (n == 0 && t == 0) break;

            for (int i = 0; i < t; i++) {

                Modular x = new Modular(io.getLong(), n);
                String op = io.getWord();
                Modular y = new Modular(io.getLong(), n);

                switch (op) {
                    case "+":
                        io.println(x.add(y));
                        break;
                    case "-":
                        io.println(x.subtract(y));
                        break;
                    case "*":
                        io.println(x.multiply(y));
                        break;
                    case "/":
                        Modular result = x.divide(y);
                        io.println(result == null ? "-1": result);
                        break;
                }
            }
        }

        io.close();
    }
}
