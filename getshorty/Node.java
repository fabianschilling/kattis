/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.Vector;

public class Node {

    int index;
    Vector<Edge> adj;
    double size;

    public Node(int index) {
        this.index = index;
        this.adj = new Vector<>();
        this.size = 0.0f;
    }
}