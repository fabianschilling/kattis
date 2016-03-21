/**
* @author Fabian Schilling (fabsch@kth.se)
*/

public class Fenwick {

    private long[] tree;
    private int n;

    public Fenwick(int n) {
        this.tree = new long[n + 1];
        this.n = n;
    }

    public long query(int index) {
        index--;
        if (index == -1) {
            return 0;
        }
        long sum = tree[0];
        while (index > 0) {
            sum += tree[index];
            index -= (index & -index);
        }
        return sum;
    }

    public void update(int index, long delta) {
        if (index == 0) {
            tree[0] += delta;
        } else {
            while (index <= n) {
                tree[index] += delta;
                index += (index & -index);
            }
        }
    }

    public static void main(String[] args) {

        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt();
        int q = io.getInt();

        Fenwick fenwick = new Fenwick(n);

        for (int i = 0; i < q; i++) {
            char op = io.getWord().charAt(0);
            int index = io.getInt();

            switch (op) {
                case '+':
                    long delta = io.getLong();
                    fenwick.update(index, delta);
                    break;
                case '?':
                    io.println(fenwick.query(index));
                    break;
                default:
                    System.exit(-1);
                    break;
            }
        }

        io.close();

    }
}
