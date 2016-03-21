/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.Arrays;

public class Main {

    public static IO io = new IO(System.in, System.out);

    public static int distance(char[] a, char[] b) {

        final int INFINITY = a.length + b.length;
        int[][] H = new int[a.length + 2][b.length + 2];
        H[0][0] = INFINITY;
        for(int i = 0; i <= a.length; i++) {
            H[i+1][1] = i;
            H[i+1][0] = INFINITY;
        }
        for(int j = 0; j <= b.length; j++) {
            H[1][j+1] = j;
            H[0][j+1] = INFINITY;
        }
        int[] DA = new int[150];
        Arrays.fill(DA, 0);
        for(int i = 1; i <= a.length; i++) {
            int DB = 0;
            for(int j = 1; j <= b.length; j++) {
                int i1 = DA[b[j-1]];
                int j1 = DB;
                int d = ((a[i-1] == b[j-1]) ? 0 : 1);
                if (d == 0) DB = j;
                H[i+1][j+1] =
                        min(H[i][j]+d,
                                H[i+1][j] + 1,
                                H[i][j+1]+1,
                                H[i1][j1] + (i-i1-1) + 1 + (j-j1-1));
            }
            DA[a[i-1]] = i;
        }
        return H[a.length + 1][b.length + 1];
    }

    private static int min(int ... nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }

    public static void main(String[] args) {

        int N = io.getInt();

        char[][] dict = new char[N][];

        for (int i = 0; i < N; i++) {
            dict[i] = io.getWord().toCharArray();
        }

        outer: while (io.hasMoreTokens()) {

            char[] pass = io.getWord().toCharArray();

            for (char[] word: dict) {

                // Continue with next candidate if words are too similar
                if (distance(word, pass.clone()) <= 3) {
                    continue outer;
                }
            }

            io.println(pass);
        }

        io.close();
    }
}
