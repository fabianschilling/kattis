/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class Library {

    public static void dijkstra(Node start) {
        start.distance = 0;

        Comparator<Node> comp = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.distance, o2.distance);
            }
        };
        PriorityQueue<Node> queue = new PriorityQueue<>(comp);
        queue.add(start);

        while (!queue.isEmpty()) {

            Node u = queue.poll();

            for (Edge e: u.adjacencies) {

                Node v = e.target;
                int weight = e.weight;
                int distance = u.distance + weight;

                if (distance < v.distance) {

                    queue.remove(v);

                    v.distance = distance;
                    v.previous = u;
                    queue.add(v);
                }
            }
        }
    }

    public static void dijkstraTimetable(Node start) {

        start.distance = 0;

        Comparator<Node> comp = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.distance, o2.distance);
            }
        };
        PriorityQueue<Node> queue = new PriorityQueue<>(comp);
        queue.add(start);

        while (!queue.isEmpty()) {

            Node u = queue.poll();

            for (Edge e: u.adjacencies) {

                int distance = e.t0 + e.weight;

                if (u.distance > e.t0) {
                    if (e.P == 0) { // cannot be reached
                        distance = Integer.MAX_VALUE;
                    } else { // find the next possible time to traverse
                        int steps = 1 + (((u.distance - e.t0) - 1) / e.P);
                        distance = e.t0 + steps * e.P + e.weight;
                    }
                }

                Node v = e.target;
                if (distance < v.distance) {
                    queue.remove(v);
                    v.distance = distance;
                    v.previous = u;
                    queue.add(v);
                }
            }
        }
    }

    public static void bellmanFord(Node[] nodes, Edge[] edges, Node start) {

        start.distance = 0;

        for (int i = 0; i < nodes.length; i++) {
            for (Edge e: edges) {
                if (e.source.distance != Integer.MAX_VALUE && e.source.distance + e.weight < e.target.distance) {
                    e.target.distance = e.source.distance + e.weight;
                    e.target.previous = e.source;
                }
            }
        }

        for (int i = 0; i < nodes.length; i++) {
            for (Edge e: edges) {
                if (e.source.distance == Integer.MIN_VALUE) {
                    e.target.distance = Integer.MIN_VALUE;
                } else if (e.source.distance != Integer.MAX_VALUE && e.source.distance + e.weight < e.target.distance) {
                    e.target.distance = Integer.MIN_VALUE;
                }
            }
        }
    }

    public static void prim(Node[] nodes) {

        Comparator<Node> comp = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.distance, o2.distance);
            }
        };
        PriorityQueue<Node> queue = new PriorityQueue<>(comp);
        for (Node node: nodes) {
            queue.add(node);
        }

        Node peek = queue.peek();
        peek.distance = 0;

        while (!queue.isEmpty()) {
            Node u = queue.poll();

            for (Edge edge: u.adjacencies) {

                Node v = edge.target;

                if (!v.visited && edge.weight < v.distance) {
                    queue.remove(v);
                    v.distance = edge.weight;
                    v.previous = u;
                    u.visited = true;
                    queue.add(v);
                }
            }
        }
    }
}
