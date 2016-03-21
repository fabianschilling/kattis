/**
* @author Fabian Schilling (fabsch@kth.se)
*/

public class UnionFind {

    static final int MAX = 1000000;

    static int n; // 1 <= n <= 1,000,000
    static int q; // 0 <= q <= 1,000,000


    static Kattio io = new Kattio(System.in, System.out);

    private int[] parents;
    private int[] height;

    public UnionFind(int nodes) {
        this.parents = new int[nodes];
        this.height = new int[nodes];

        for (int i = 0; i < nodes; i++) {
            parents[i] = i; // make self-connection
        }
    }

    public int find(int node) {
        if (parents[node] != node) {
            parents[node] = find(parents[node]);
        }
        return parents[node];
    }

    public boolean same(int a, int b) {
        return find(a) == find(b);
    }

    public void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            return;
        }

        if (height[aRoot] < height[bRoot]) {
            parents[aRoot] = bRoot;
        } else if (height[aRoot] > height[bRoot]) {
            parents[bRoot] = aRoot;
        } else {
            parents[bRoot] = aRoot; // doesn't matter
            height[aRoot] += 1;
        }
    }

    public static void main(String[] args) {

        n = io.getInt();
        q = io.getInt();

        UnionFind unionFind = new UnionFind(n);

        while (io.hasMoreTokens()) {

            char op = io.getWord().charAt(0);
            int a = io.getInt();
            int b = io.getInt();

            switch (op) {
                case '=':
                    unionFind.union(a, b);
                    break;
                case '?':
                    if (unionFind.same(a, b)) {
                        io.println("yes");
                    } else {
                        io.println("no");
                    }
                    break;
                default:
                    System.exit(-1);
            }

        }

        io.close();
    }
}
