/**
* @author Fabian Schilling (fabsch@kth.se)
*/

public class Main {

    public static IO io = new IO(System.in, System.out);

    public static void shortestpath1() {

        while (io.hasMoreTokens()) {

            int n = io.getInt(); // number of nodes in the graph
            if (n == 0) break;
            int m = io.getInt(); // number of edges
            int q = io.getInt(); // number of queries
            int s = io.getInt(); // index of the starting node

            Node[] nodes = new Node[n];

            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(i);
            }

            for (int i = 0; i < m; i++) {
                int u = io.getInt();
                int v = io.getInt();
                int w = io.getInt();

                nodes[u].adjacencies.add(new Edge(nodes[v], w));

            }

            Library.dijkstra(nodes[s]);

            for (int i = 0; i < q; i++) {
                int query = io.getInt();

                int distance = nodes[query].distance;

                if (distance == Integer.MAX_VALUE) {
                    io.println("Impossible");
                } else {
                    io.println(distance);
                }

            }

            io.println();
        }
    }

    public static void shortestpath2() {

        while (io.hasMoreTokens()) {

            int n = io.getInt(); // number of nodes in the graph
            if (n == 0) break;
            int m = io.getInt(); // number of edges
            int q = io.getInt(); // number of queries
            int s = io.getInt(); // index of the starting node

            Node[] nodes = new Node[n];

            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(i);
            }

            for (int i = 0; i < m; i++) {
                int u = io.getInt();
                int v = io.getInt();
                int t0 = io.getInt();
                int P = io.getInt();
                int d = io.getInt();

                nodes[u].adjacencies.add(new Edge(nodes[v], d, t0, P));

            }

            Library.dijkstraTimetable(nodes[s]);

            for (int i = 0; i < q; i++) {
                int query = io.getInt();

                int distance = nodes[query].distance;

                if (distance == Integer.MAX_VALUE) {
                    io.println("Impossible");
                } else {
                    io.println(distance);
                }

            }

            io.println();
        }

    }

    public static void main(String[] args) {

        //shortestpath1();
        shortestpath2();
        io.close();
    }
}
