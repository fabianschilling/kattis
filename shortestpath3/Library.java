/**
* @author Fabian Schilling (fabsch@kth.se)
*/

/**
 * Author: Fabian Schilling & Hugo Sandelius
 */

import java.util.*;

public class Library {

    // shortestpath1
    public static void dijkstra(Node start) {
        start.distance = 0;

        Comparator<Node> comp = (o1, o2) -> Integer.compare(o1.distance, o2.distance);
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

    // shortestpath2
    public static void dijkstraTimetable(Node start) {

        start.distance = 0;

        Comparator<Node> comp = (o1, o2) -> Integer.compare(o1.distance, o2.distance);
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

    // shortestpath3
    public static void bellmanFord(Node[] nodes, Edge[] edges, Node start) {

        start.distance = 0;

        for (int i = 1; i < nodes.length; i++) {
            for (Edge e: edges) {
                if (e.source.distance != Integer.MAX_VALUE && e.source.distance + e.weight < e.target.distance) {
                    e.target.distance = e.source.distance + e.weight;
                    e.target.previous = e.source;
                }
            }
        }

        //System.out.println("Detecting negative cycles...");
        for (int i = 1; i < nodes.length; i++) {
            //System.out.println("Round " + i);
            for (Edge e: edges) {
                if (e.source.distance == Integer.MIN_VALUE) {
                    e.target.distance = Integer.MIN_VALUE;
                } else if (e.source.distance != Integer.MAX_VALUE && e.source.distance + e.weight < e.target.distance) {
                    e.target.distance = Integer.MIN_VALUE;
                }
            }
        }
    }

    // construct path
    public static Vector<Node> constructPathTo(Node end) {
        Vector<Node> path = new Vector<>();
        Node prev = end;
        while (prev != null) {
            path.insertElementAt(prev, 0);
            prev = prev.previous;
        }
        return path;
    }

    public static void printPathTo(Node end) {
        Vector<Node> path = constructPathTo(end);
        System.err.print("Path: ");
        for (Node node: path) {
            System.err.print(node.index + " ");
        }
        System.err.println();
    }

    // minspantree
    public static void prim(Node[] nodes) {

        // Order nodes by distance
        Comparator<Node> comp = (o1, o2) -> Integer.compare(o1.distance, o2.distance);
        PriorityQueue<Node> queue = new PriorityQueue<>(comp);

        // Add all nodes to queue
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

    // allpairspath
    public static void floydWarshall(int[][] dist) {

        // Initialize self-connections as 0
        for (int i = 0; i < dist.length; i++) {
            dist[i][i] = 0;
        }

        // Run Floyd-Warshall
        for (int k = 0; k < dist.length; k++) {
            for (int i = 0; i < dist.length; i++) {
                for (int j = 0; j < dist.length; j++) {

                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                        continue; // dont even have to look at this
                    }

                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Detect negative cycles
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                for (int k = 0; dist[i][j] != Integer.MIN_VALUE && k < dist.length; k++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[k][k] < 0) {
                        dist[i][j] = Integer.MIN_VALUE;
                    }
                }
            }
        }
    }
}