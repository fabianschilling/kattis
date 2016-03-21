/**
* @author Fabian Schilling (fabsch@kth.se)
*/


public class Edge implements Comparable<Edge> {

    public Node from;
    public Node to;
    public double distance;

    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
        this.distance = Math.sqrt(Math.pow(from.x - to.x, 2) + Math.pow(from.y - to.y, 2));
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(distance, o.distance);
    }
}
