/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.*;

public class Main {

    public static IO io = new IO(System.in, System.out);

    public static void main(String[] args) {

        while (io.hasMoreTokens()) {
            int n = io.getInt(); // number of intersections
            int m = io.getInt(); // number of corridors
            if (n == 0 && m == 0) break;

            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(i);
            }

            for (int i = 0; i < m; i++) {
                int x = io.getInt();
                int y = io.getInt();
                double f = io.getDouble();
                nodes[x].adj.add(new Edge(nodes[y], f));
                nodes[y].adj.add(new Edge(nodes[x], f));
            }

            nodes[0].size = 1.0f;

            Comparator<Node> comp = new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Double.compare(o2.size, o1.size);
                }
            };
            PriorityQueue<Node> queue = new PriorityQueue<>(comp);
            queue.add(nodes[0]);

            while (!queue.isEmpty()) {

                Node u = queue.poll();

                for (Edge e: u.adj) {

                    Node v = e.to;

                    if (v.size < u.size * e.factor) {

                        queue.remove(v);
                        v.size = u.size * e.factor;
                        queue.add(v);
                    }
                }
            }

            io.println(String.format("%.4f", nodes[n - 1].size));


        }

        io.close();
    }
}
