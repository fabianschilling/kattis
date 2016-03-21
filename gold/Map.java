/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.Vector;

public class Map {

    char[][] map;
    boolean[][] visited;
    int width;
    int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new char[height][width];
        this.visited = new boolean[height][width];
    }

    public char get(int x, int y) {
        return map[y][x];
    }

    public char get(Position p) {
        return map[p.y][p.x];
    }

    public void set(int x, int y, char value) {
        map[y][x] = value;
    }

    public void set(Position p, char value) {
        map[p.y][p.x] = value;
    }

    public boolean isVisited(Position p) {
        return visited[p.y][p.x];
    }

    public void setVisited(Position p) {
        visited[p.y][p.x] = true;
    }

    public Vector<Position> adjacentTo(Position p) {
        Vector<Position> pos = new Vector<>();
        if (p.x - 1 >= 0) {
            pos.add(new Position(p.x - 1, p.y));
        }
        if (p.x + 1 < width) {
            pos.add(new Position(p.x + 1, p.y));
        }
        if (p.y - 1 >= 0) {
            pos.add(new Position(p.x, p.y - 1));
        }
        if (p.y + 1 < height) {
            pos.add(new Position(p.x, p.y + 1));
        }
        return pos;
    }

    public boolean containsTrap(Position p) {
        for (Position pos: adjacentTo(p)) {
            if (get(pos) == 'T') {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String result = "Map = \n";
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result += map[y][x];
            }
            result += "\n";
        }

        result += "Visited = \n";
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (visited[y][x]) {
                    result += "X";
                } else {
                    result += "O";
                }
            }
            result += "\n";
        }

        return result + "\n";
    }

}
