/**
* @author Fabian Schilling (fabsch@kth.se)
*/


public class Position {

    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "Position = (" + this.x + ", " + this.y + ")";
    }
}
