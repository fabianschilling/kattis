/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.Comparator;
import java.util.Collections;
import java.util.Vector;


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

    public static void shortestpath3() {

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

            Edge[] edges = new Edge[m];

            for (int i = 0; i < m; i++) {
                int u = io.getInt();
                int v = io.getInt();
                int w = io.getInt();

                edges[i] = new Edge(nodes[u], nodes[v], w);

            }

            Library.bellmanFord(nodes, edges, nodes[s]);

            for (int i = 0; i < q; i++) {
                int query = io.getInt();

                int distance = nodes[query].distance;

                if (distance == Integer.MAX_VALUE) {
                    io.println("Impossible");
                } else if (distance == -Integer.MIN_VALUE) {
                    io.println("-Infinity");
                } else {
                    io.println(distance);
                }

            }

            io.println();
        }
    }

    public static void minspantree() {

        while (io.hasMoreTokens()) {

            int n = io.getInt(); // number of nodes in the graph
            if (n == 0) break;
            int m = io.getInt(); // number of edges

            Node[] nodes = new Node[n];

            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(i);
            }

            for (int i = 0; i < m; i++) {
                int u = io.getInt();
                int v = io.getInt();
                int w = io.getInt();

                if (u != v) {
                    nodes[u].adjacencies.add(new Edge(nodes[v], w));
                    nodes[v].adjacencies.add(new Edge(nodes[u], w)); // undirected
                }
            }

            Library.prim(nodes);

            Vector<Edge> edges = new Vector<>();
            long total = 0;

            for (Node node: nodes) {
                if (node.previous != null) {
                    total += node.distance;
                    if (node.previous.index < node.index) {
                        edges.add(new Edge(node.previous, node, node.distance));
                    } else {
                        edges.add(new Edge(node, node.previous, node.distance));
                    }
                }
            }

            if (edges.isEmpty() || edges.size() != n - 1) {
                io.println("Impossible");
            } else {

                // lexicographic sort
                Collections.sort(edges, new Comparator<Edge>() {
                    @Override
                    public int compare(Edge o1, Edge o2) {
                        if (o1.source.index != o2.source.index) {
                            return Integer.compare(o1.source.index, o2.source.index);
                        } else {
                            return Integer.compare(o1.target.index, o2.target.index);
                        }
                    }
                });
                io.println(total);
                for (Edge e: edges) {
                    io.println(e.source.index + " " + e.target.index);
                }
            }
        }

    }

    public static void allpairspath() {

        while (io.hasMoreTokens()) {
            int n = io.getInt(); // 1 <= n <= 150 number of nodes
            if (n == 0) break;
            int m = io.getInt(); // 0 <= m <= 5000 number of edges
            int q = io.getInt(); // 0 <= q <= 1000 number of queries

            int[][] G = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    G[i][j] = Integer.MAX_VALUE;
                }
            }

            for (int i = 0; i < m; i++) {
                int u = io.getInt(); // edge from node u...
                int v = io.getInt(); // ... to node v with...
                int w = io.getInt(); // ... weight -1000 <= w <= 1000
                if (G[u][v] > w) {
                    G[u][v] = w; // double edges, take lowest one!
                }

            }

            Library.floydWarshall(G);

            for (int i = 0; i < q; i++) {
                int u = io.getInt();
                int v = io.getInt();
                if (G[u][v] == Integer.MAX_VALUE) {
                    io.println("Impossible");
                } else if (G[u][v] == Integer.MIN_VALUE) {
                    io.println("-Infinity");
                } else {
                    io.println(G[u][v]);
                }
            }

            io.println(); // print blank line after each test case
        }
    }

    public static void main(String[] args) {

        //shortestpath1();
        //shortestpath2();
        //shortestpath3();
        //minspantree();
        allpairspath();
        io.close();
    }
}
