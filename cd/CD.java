/**
* @author Fabian Schilling (fabsch@kth.se)
*/


public class CD {

    static final int M = 1000000;

    static Kattio io = new Kattio(System.in, System.out);

    static int[] nlist = new int[M];
    static int[] mlist = new int[M];

    public static void main(String[] args) {

        while (true) {

            int n = io.getInt();
            int m = io.getInt();

            if (n == 0 && m == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                nlist[i] = io.getInt();
            }

            for (int i = 0; i < m; i++) {
                mlist[i] = io.getInt();
            }

            int sell = 0;
            int ni = 0, mi = 0;

            while (ni < n && mi < m) {
                if (nlist[ni] > mlist[mi]) {
                    mi++;
                } else if (nlist[ni] < mlist[mi]) {
                    ni++;
                } else {
                    sell++;
                    ni++;
                    mi++;
                }
            }

            io.println(sell);
        }
        io.close();
    }
}
