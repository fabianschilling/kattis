/**
* @author Fabian Schilling (fabsch@kth.se)
*/


public class Main {

    public static IO io = new IO(System.in, System.out);

    // naive solution

    public static void main(String[] args) {

        next: while (io.hasMoreTokens()) {

            int n = io.getInt(); //n!
            int m = io.getInt(); // candidate m
            if (m == 0) { // non-negative -> 0 divides nothing
                io.println(m + " does not divide " + n + "!");
                continue;
            }
            if (m == 1) { // non-negative -> 1 divides everything
                io.println(m + " divides " + n + "!");
                continue;
            }
            if(m <= n) {
                io.println(m + " divides " + n + "!");
                continue;
            }


            int candidate = m; // m is mutable, so keep copy
            int count = 0; // factor count

            // Find factors of candidate up to sqrt(m)
            for (int factor = 2; factor <= (int) Math.ceil(Math.sqrt(m)); factor++) {

                // Count number of factors in m
                while (m % factor == 0) {
                    m /= factor;
                    count++;
                }

                // If factors found
                if (count > 0) {

                    // Check if n! contains those factors
                    for (int j = factor; j <= n; j *= factor) {
                        count -= n / j;
                    }

                    // If n! does not contain all the factors, it m can't possibly divide n!
                    if (count > 0) {
                        io.println(candidate + " does not divide " + n + "!");
                        continue next; // continue with next test case
                    }
                }

                count = 0; // reset factor count
            }

            // only if m <= n can m divide n!
            if (m <= n) {
                io.println(candidate + " divides " + n + "!");
            } else {
                io.println(candidate + " does not divide " + n + "!");

            }
        }

        io.close();
    }
}
