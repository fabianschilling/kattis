/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

    public static IO io = new IO(System.in, System.out);

    public static int END = "***END***".hashCode();
    public static int EMPTY = "".hashCode();

    public static String strip(String str) {
        return str.trim().replaceAll(" +", " ");
    }

    public static void main(String[] args) {

        int N = io.getInt();

        String[] names = new String[N];
        int fragments[][] = new int[N][];

        for (int i = 0; i < N; i++) {
            names[i] = strip(io.getLine());
            ArrayList<Integer> temp = new ArrayList<>();
            int line = strip(io.getLine()).hashCode();
            while (line != END) {
                if (line != EMPTY) {
                    temp.add(line);
                }
                line = strip(io.getLine()).hashCode();
            }
            fragments[i] = new int[temp.size()];
            for (int j = 0; j < temp.size(); j++) {
                fragments[i][j] = temp.get(j);
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        int line = strip(io.getLine()).hashCode();
        while (line != END) {
            if (line != EMPTY) {
                temp.add(line);
            }
            line = strip(io.getLine()).hashCode();
        }
        int[] code = new int[temp.size()];
        for (int i = 0; i < code.length; i++) {
            code[i] = temp.get(i);
        }

        ArrayList<String> output = new ArrayList<>();
        int longestSoFar = 0;

        for (int i = 0; i < fragments.length; i++) {

            int[] frag = fragments[i];
            int current = longest(code, frag);
            if (current == longestSoFar) {
                output.add(names[i]);
            } else if (current > longestSoFar) {
                output.clear();
                output.add(names[i]);
                longestSoFar = current;
            }

        }

        io.print(longestSoFar + " ");
        if (longestSoFar > 0) {
            for (String name: output) {
                io.print(name + " ");
            }
        }
        io.println();


        io.close();

    }

    public static int longest(int[] s, int[] t) {

        int m = s.length;
        int n = t.length;
        int[][] l = new int[m][n];
        int z = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s[i] == t[j]) {
                    if (i == 0 || j == 0) {
                        l[i][j] = 1;
                    } else {
                        l[i][j] = l[i - 1][j - 1] + 1;
                    }
                    if (l[i][j] > z) {
                        z = l[i][j];
                    }
                } else {
                    l[i][j] = 0;
                }
            }
        }

        return z;
    }
}
