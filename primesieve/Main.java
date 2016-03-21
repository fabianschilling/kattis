/**
* @author Fabian Schilling (fabsch@kth.se) and Hugo Sandelius (hugosa@kth.se)
*/
 
public class Main {

    public static IO io = new IO(System.in, System.out);

    public static void main(String[] args) {

        int n = io.getInt();
        int q = io.getInt();

        PrimeSieve sieve = new PrimeSieve(n);
        io.println(sieve.numPrimes);

        for (int i = 0; i < q; i++) {
            io.println(sieve.isPrime(io.getInt()));
        }

        io.close();

    }
}
