/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static IO io = new IO(System.in, System.out);

    public static void main(String[] args) {

        long N = io.getLong();

        long maxZeros = 0;
        long minBase = 2;
        for (long base = N; base >= 2; base--) {
            long n = N;
            long zeros = 0;
            while (n % base == 0) {
                n /= base;
                zeros++;
            }
            if (zeros >= maxZeros) {
                maxZeros = zeros;
                minBase = base;
            }
        }

        io.println(minBase);

        io.close();
    }
}