/**
* @author Fabian Schilling (fabsch@kth.se)
*/


public class Edge {

    public Node target;
    public int weight;

    public Edge(Node target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}
