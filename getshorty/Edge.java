/**
* @author Fabian Schilling (fabsch@kth.se)
*/

public class Edge {

    double factor;
    Node to;

    public Edge(Node to, double factor) {
        this.to = to;
        this.factor = factor;
    }
}
