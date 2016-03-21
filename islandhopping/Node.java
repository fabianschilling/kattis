/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.Vector;

public class Node {

    public double x;
    public double y;
    public int index;
    public Node parent;
    public Vector<Edge> adj;

    public Node(double x, double y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
        this.parent = this;
        this.adj = new Vector<>();
    }

    public Node find() {
        if (this.parent.index == this.index) {
            return this;
        } else {
            return this.parent.find();
        }
    }

    public void union(Node y) {
        Node xRoot = find();
        Node yRoot = y.find();
        this.parent = yRoot;
    }


}
