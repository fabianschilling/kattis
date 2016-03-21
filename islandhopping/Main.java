/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Vector;

public class Main {

    static IO io = new IO(System.in, System.out);

    public static void main(String[] args) {

        int n = io.getInt(); // Number of test cases

        for (int test = 0; test < n; test++) {

            int m = io.getInt(); // Number of islands

            Node[] nodes = new Node[m];

            for (int i = 0; i < m; i++) {

                double x = io.getDouble();
                double y = io.getDouble();

                nodes[i] = new Node(x, y, i);
            }

            Vector<Edge> edges = new Vector<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (i != j) {
                        edges.add(new Edge(nodes[i], nodes[j]));
                    }
                }
            }

            Collections.sort(edges);
            UnionFind unionfind = new UnionFind(m);
            Vector<Edge> sol = new Vector<>();

            for (Edge e: edges) {

                if (unionfind.find(e.from.index) != unionfind.find(e.to.index)) {
                    sol.add(e);
                    unionfind.union(e.from.index, e.to.index);
                }
            }

            double distance = 0.0;
            for (Edge e: sol) {
                distance += e.distance;
            }

            io.println(distance);

        }


        io.close();
    }
}
