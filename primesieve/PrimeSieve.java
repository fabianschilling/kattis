/**
* @author Fabian Schilling (fabsch@kth.se) and Hugo Sandelius (hugosa@kth.se)
*/

import java.util.BitSet;

public class PrimeSieve {

    BitSet sieve;
    int numPrimes;

    public PrimeSieve(int n) {

        sieve = new BitSet(n); // sieve[i - 1] = true -> i is prime, 0 otherwise
        sieve.set(1, n, true); // 1 not prime, therefore sieve[0] = false
        numPrimes = n - 1; // count primes backwards

        // Sieve
        for (int p = 2; p <= (int) Math.ceil(Math.sqrt(n)); p++) {
            // Cross out only if p is prime
            if (sieve.get(p - 1)) {
                for (int j = p * p; j <= n; j += p) {
                    if (sieve.get(j - 1)) {
                        // Count primes backwards, no need for extra loop
                        numPrimes--;
                    }
                    sieve.set(j - 1, false);
                }
            }
        }
    }

    public int isPrime(int n) {
        return sieve.get(n - 1) ? 1: 0;
    }
}
