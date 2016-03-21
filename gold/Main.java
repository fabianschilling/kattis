/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static IO io = new IO(System.in, System.out);

    public static void main(String[] args) {

        int width = io.getInt(); // Width of the board (W)
        int height = io.getInt(); // Height of the board (H)

        // Fill map
        Map map = new Map(width, height);
        Position start = null;
        for (int y = 0; y < height; y++) {
            char[] line = io.getWord().toCharArray();
            for (int x = 0; x < width; x++) {
                Position pos = new Position(x, y);
                map.set(pos, line[x]);
                if (line[x] == 'P') { // memorize starting position
                    start = new Position(x, y);
                    map.setVisited(pos);
                } else if (line[x] == '#') { // set unreachable fields visited
                    map.setVisited(pos);
                }
            }
        }

        Queue<Position> q = new LinkedList<>();
        q.add(start);

        int gold = 0;
        while (!q.isEmpty()) {
            Position u = q.remove();
            if (map.get(u) == 'G') {
                gold++;
            }
            if (map.containsTrap(u)) {
                continue;
            }
            for(Position v: map.adjacentTo(u)) {
                if (!map.isVisited(v) && map.get(v) != 'T') {
                    map.setVisited(v);
                    q.add(v);
                }
            }

        }

        io.println(gold);

        io.close();
    }
}
