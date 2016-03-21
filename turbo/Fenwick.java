/**
* @author Fabian Schilling (fabsch@kth.se)
*/


public class Fenwick {

    static final int MAX = 1000000;

    private long[] tree;
    private int n;

    public Fenwick(int n) {
        this.tree = new long[MAX];
        this.n = n;
    }

    public long query(int index) {
        long result = 0;
        for (int i = index; i > 0; i -= (i & -i)) {
            result += tree[i];
        }
        return result;
    }

    public void update(int index, long delta) {
        for (int i = index; i <= n; i += (i &-i)) {
            tree[i] += delta;
        }
    }

    public long sum(int left, int right) {
        return query(right) - query(left - 1);
    }
}
