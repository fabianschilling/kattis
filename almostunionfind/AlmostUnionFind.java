/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.*;

public class AlmostUnionFind {

    static Kattio io = new Kattio(System.in, System.out);
    static int n; // 1 <= n <= 100000
    static int m; // 1 <= n <= 100000

    private int[] root;
    private ArrayList<Integer>[] sets;

    @SuppressWarnings("unchecked")
    public AlmostUnionFind(int nodes) {
        root = new int[nodes + 1];
        sets = new ArrayList[nodes + 1];

        for (int i = 1; i <= nodes; i++) {
            root[i] = i; // make self-connection
            sets[i] = new ArrayList<>();
            sets[i].add(i);
        }
    }

    public void union(int p, int q) {

        int x = root[p];
        int y = root[q];

        if (x == y) {
            return; // already in the same set
        }

        if (sets[x].size() >= sets[y].size()) {
            for (int i = 0; i < sets[y].size(); i++) {
                int n = (Integer) sets[y].get(i);
                sets[x].add(n);
                root[n] = x;
            }
            sets[y].clear();
        } else {
            for (int i = 0; i < sets[x].size(); i++) {
                int n = (Integer) sets[x].get(i);
                sets[y].add(n);
                root[n] = y;
            }
            sets[x].clear();
        }
    }

    public void move(int p, int q) {

        if (root[p] == root[q]) {
            return; // already int the same set
        }

        sets[root[p]].remove((Object) p);
        sets[root[q]].add(p);
        root[p] = root[q];

    }

    public int sum(int p) {
        int sum = 0;
        for (int i = 0; i < sets[root[p]].size(); i++) {
            sum += (Integer) sets[root[p]].get(i);
        }
        return sum;
    }

    public int count(int p) {
        return sets[root[p]].size();
    }

    public static void main(String[] args) {

        while (io.hasMoreTokens()) {

            n = io.getInt();
            m = io.getInt();

            AlmostUnionFind almost = new AlmostUnionFind(n);

            for (int i = 0; i < m; i++) {

                int op = io.getInt();

                switch (op) {
                    case 1: // union p and q
                        int p = io.getInt();
                        int q = io.getInt();
                        almost.union(p, q);
                        break;
                    case 2: // move p to set containing q
                        int x = io.getInt();
                        int y = io.getInt();
                        almost.move(x, y);
                        break;
                    case 3: // numsum
                        int z = io.getInt();
                        int sum = almost.sum(z);
                        int count = almost.count(z);
                        System.out.println(count + " " + sum);
                        //io.println(count + " " + sum);
                        break;
                    default:
                        System.out.println("Shit...");
                }
            }
        }

        io.close();
    }
}
