/**
* @author Fabian Schilling (fabsch@kth.se)
*/


public class Edge {

    // shortestpath1
    public Node target;
    public int weight;

    // shortestpath2
    public int t0;
    public int P;

    // shortestpath3
    public Node source;

    // shortestpath1
    public Edge(Node target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    // shortestpath2
    public Edge(Node target, int weight, int t0, int P) {
        this.target = target;
        this.weight = weight;
        this.t0 = t0;
        this.P = P;
    }

    // shortestpath3
    public Edge(Node source, Node target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }
}
