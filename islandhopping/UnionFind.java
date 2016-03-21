/**
* @author Fabian Schilling (fabsch@kth.se)
*/


public class UnionFind {

    int[] parent;

    public UnionFind(int n) {
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return find(parent[x]);
        }
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        parent[xRoot] = yRoot;
    }
}
