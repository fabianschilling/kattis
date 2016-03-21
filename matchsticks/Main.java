/**
* @author Fabian Schilling (fabsch@kth.se)
*/


public class Main {

    public static IO io = new IO(System.in, System.out);
    // Solutions for n <= 20:  2, 3, 4, 5, 6, ... (offline)
    public static int[] sol = {1, 7, 4, 2, 6, 8, 10, 18, 22, 20, 28, 68, 88, 108, 188, 200, 208, 288, 688, 888};

    public static void main(String[] args) {

        int testcases = io.getInt();

        for (int testcase = 0; testcase < testcases; testcase++) {

            int n = io.getInt();
            io.println(min(n) + " " + max(n));
        }

        io.close();
    }

    public static String min(int n) {

        String res = "";

        // Computed offline
        if (n <= 20) {
            return res + sol[n - 2];
        }

        // Solutions keep repeating (appended with 8s)
        int digits = (n / 7) - 3; // subtract # of digits needed for beginning
        int index = (n % 7) + 12; // take beginning as precomputed solution

        res += sol[index];

        // Append 8s to get solution
        for (int i = 0; i <= digits; i++) {
            res += "8";
        }

        return res;
    }

    public static String max(int n) {

        String res = "";

        // Add a 7 if the number is odd
        if (n % 2 == 1) {
            res += "7";
            n -= 3;
        }

        // Fill the rest up with 1s
        for (int i = 0; i < n / 2; i++) {
            res += "1";
        }

        return res;
    }
}
