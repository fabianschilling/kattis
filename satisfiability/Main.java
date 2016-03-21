/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.Vector;

public class Main {

    public static IO io = new IO(System.in, System.out);
    public static int n; // 1 <= n <= 20 number of variables
    public static int m; // 1 <= m <= 100 number of clauses

    public static boolean solve(int[][] cnf) {

        // Try all possible assignments
        for (int i = 0; i < (1 << n); i++) {

            boolean cnfSatisfiable = true;
            for (int[] clause: cnf) {

                boolean clauseSatisfiable = false;
                for (Integer literal: clause) {

                    if (literal > 0) { // non-negated
                        if (((1 << (literal - 1)) & i) > 0) { // satisfiable
                            clauseSatisfiable = true;
                            break;
                        }
                    } else { // negated
                        if (((1 << (-literal - 1)) & i) == 0) { // satisfiable
                            clauseSatisfiable = true;
                            break;
                        }
                    }
                }

                if (!clauseSatisfiable) {
                    cnfSatisfiable = false;
                    break;
                }
            }

            if (cnfSatisfiable) {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {

        int testCases = io.getInt();

        for (int testCase = 0; testCase < testCases; testCase++) {

            n = io.getInt();
            m = io.getInt();

            int[][] cnf = new int[m][];

            for (int i = 0; i < m; i++) {
                String[] split = io.getLine().split(" v ");

                cnf[i] = new int[split.length];
                for (int j = 0; j < split.length; j++) {

                    String literal = split[j];

                    if (literal.startsWith("~")) {
                        cnf[i][j] = Integer.parseInt(literal.substring(2)) * -1;
                    } else {
                        cnf[i][j] = Integer.parseInt(literal.substring(1));
                    }

                }
            }


            if (solve(cnf)) {
                io.println("satisfiable");
            } else {
                io.println("unsatisfiable");
            }
        }

        io.close();
    }
}
