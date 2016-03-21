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
}
