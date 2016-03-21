/**
* @author Fabian Schilling (fabsch@kth.se)
*/


public class Main {

    public static IO io = new IO(System.in, System.out);

    public static int solve(char[] w) {

        int swaps = 0;
        int l = 0;
        int r = w.length - 1;

        // Iterate over string from both sides
        outer: while (l <= r) {

            // If the left char does not match the right one we need to swap
            if (w[l] != w[r]) {

                int ll = l + 1;
                int rr = r - 1;
                int end = rr;

                // Find next char that matches w[l] or w[r]
                while (ll <= end) {

                    // If match found for left side
                    if (w[l] == w[rr]) {

                        // Keep swapping to the right
                        while (w[l] != w[r]) {

                            char t = w[rr];
                            w[rr] = w[rr + 1];
                            w[rr + 1] = t;
                            swaps++;
                            rr++;
                        }

                        continue outer;

                    // If match found on the right side
                    } else if(w[r] == w[ll]) {

                        // Keep swapping to the left
                        while (w[l] != w[r]) {

                            char t = w[ll];
                            w[ll] = w[ll - 1];
                            w[ll - 1] = t;
                            swaps++;
                            ll--;
                        }

                        continue outer;
                    }

                    ll++;
                    rr--;
                }

                // No matching char found, cannot construct palindrome
                return -1;

            }

            l++;
            r--;
        }

        return swaps;
    }

    public static void main(String[] args) {

        int tests = io.getInt();

        for (int test = 0; test < tests; test++) {

            char[] w = io.getWord().toCharArray();

            int swaps = solve(w);
            if (swaps == -1) {
                io.println("Impossible");
            } else {
                io.println(swaps);
            }
        }

        io.close();
    }
}
