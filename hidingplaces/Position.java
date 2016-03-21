/**
* @author Fabian Schilling (fabsch@kth.se)
*/


public class Position {

    int x;
    int y;
    int jumps;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.jumps = 0;
    }

    public Position(int x, int y, int jumps) {
        this.x = x;
        this.y = y;
        this.jumps = jumps;
    }

    public Position(String pos) {
        char[] xy = pos.toCharArray();
        this.x = (int) xy[0] - 97; // char to int
        this.y =  8 - ((int) xy[1] - 48); // char to int
    }

    public String chessNotation() {
        char x = (char) (this.x + 97);
        char y = (char) ((8 - this.y) + 48);
        return "" + x + y;
    }

    public String toString() {
        return this.chessNotation();// + " @ " + this.jumps;
    }
}
