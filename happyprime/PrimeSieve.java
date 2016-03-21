/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.BitSet;
import java.util.HashMap;

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

    public boolean isPrime(int n) {
        return sieve.get(n - 1);
    }

    public boolean isHappy(int n) {

        HashMap<Integer, Boolean> hash = new HashMap<>();

        while (true) {

            int s = 0;
            int x = 0;

            while (n > 0) {
                x = n % 10;
                n /= 10;
                s += x * x;
            }
            n = s;

            if (hash.containsKey(n)) {
                return false; // contains cycle
            } else if (n == 1) {
                return true; // is happy
            }

            hash.put(n, true);

        }
    }
}
