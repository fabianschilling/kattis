/**
* @author Fabian Schilling (fabsch@kth.se)
*/


public class Main {

    public static IO io = new IO(System.in, System.out);

    public static long countZerosUpTo(long n) {

        long zeros = 0;
        long digit, sliceLeft, sliceRight;

        for (int i = 1; ; i *= 10) {

            // Slice number and get middle digit
            digit = n / i;
            sliceRight = n % i;
            sliceLeft = digit / 10;
            digit = digit % 10;

            // Whole number processed
            if (sliceLeft == 0) {
                return zeros;
            }

            // Special case for digit zero
            if (digit == 0) {
                zeros += (sliceLeft - 1) * i + sliceRight + 1;
            } else {
                zeros += sliceLeft * i;
            }
        }
    }

    public static long countZeros(long n) {

        long zeros = 0;

        // Special case for zero
        if (n == 0) {
            return 1;
        }

        // Count zeros
        while (n > 0) {
            if (n % 10 == 0) {
                zeros++;
            }
            n /= 10;
        }

        return zeros;
    }

    public static void main(String[] args) {

        while (io.hasMoreTokens()) {

            long m = io.getLong();
            if (m < 0) break;
            long n = io.getLong();

            long zeros = countZeros(m);
            long lower = countZerosUpTo(m);
            long upper = countZerosUpTo(n);


            io.println(zeros + upper - lower);

        }

        io.close();
    }
}
