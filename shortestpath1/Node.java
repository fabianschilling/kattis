/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.Vector;

public class Node {

    public int index;
    public Vector<Edge> adjacencies;
    public int distance;
    public Node previous;

    public Node(int index) {
        this.index = index;
        this.adjacencies = new Vector<>();
        this.distance = Integer.MAX_VALUE;
        this.previous = null;
    }

}
