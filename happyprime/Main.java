/**
* @author Fabian Schilling (fabsch@kth.se)
*/


public class Main {

    public static IO io = new IO(System.in, System.out);

    public static int MAX = 10000;

    public static void main(String[] args) {

        int testcases = io.getInt();

        PrimeSieve sieve = new PrimeSieve(MAX);

        for (int testcase = 0; testcase < testcases; testcase++) {

            int K = io.getInt();
            int m = io.getInt();

            if (sieve.isPrime(m) && sieve.isHappy(m)) {
                io.println(K + " " + m + " YES");
            } else {
                io.println(K + " " + m + " NO");
            }
        }

        io.close();

    }
}
