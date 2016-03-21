/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.Arrays;
import java.util.HashMap;


public class Turbo {

    static Kattio io = new Kattio(System.in, System.out);

    static int LEN = 100001;

    static int n;
    static int[] nums = new int[LEN]; // mapping from index to number
    static int[] pos = new int[LEN]; // mapping from number to index

    static Fenwick shift = new Fenwick(LEN); // keeps track of the shift


    public static void solve() {

        int left = 1;
        int right = n;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) { // odd
                shift.update(pos[left], -1);
                io.println(shift.sum(1, pos[left]));
                left++; // move one step right
            } else { // even
                shift.update(pos[right], -1);
                io.println(shift.sum(pos[right], n));
                right--; // move one step left
            }
        }
    }

    public static void main(String[] args) {

        n = io.getInt();

        for (int i = 1; i <= n; i++) {
            int num = io.getInt();
            nums[i] = num;
            pos[num] = i;
            shift.update(i, 1);
        }

        solve();

        io.close();
    }
}
