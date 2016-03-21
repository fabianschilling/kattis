/**
* @author Fabian Schilling (fabsch@kth.se)
*/

/**
 * Author: Fabian Schilling & Hugo Sandelius
 */

import java.util.Vector;

public class Node {

    // shortestpath1,2,3
    public int index;
    public Vector<Edge> adjacencies;
    public int distance;
    public Node previous;

    // minspantree
    public boolean visited;

    // shortestpath1,2,3
    public Node(int index) {
        this.index = index;
        this.adjacencies = new Vector<>();
        this.distance = Integer.MAX_VALUE;
        this.previous = null;
        this.visited = false;
    }
}