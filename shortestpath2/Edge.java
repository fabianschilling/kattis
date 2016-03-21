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

    public Edge(Node target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    public Edge(Node target, int weight, int t0, int P) {
        this.target = target;
        this.weight = weight;
        this.t0 = t0;
        this.P = P;
    }
}
