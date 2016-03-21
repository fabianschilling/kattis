/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.*;

public class Main {

    public static IO io = new IO(System.in, System.out);

    public static void main(String[] args) {

        int n = io.getInt();

        for (int i = 0; i < n; i++) {
            Board board = new Board();
            Position start = new Position(io.getWord());
            board.setVisited(start);

            Vector<Position> positions = new Vector<>();
            Queue<Position> queue = new LinkedList<>();
            queue.add(start);

            while (!queue.isEmpty()) {

                Position u = queue.remove();

                positions.add(u);

                for (Position v: board.getMovesFrom(u)) {
                    if (!board.isVisited(v)) {
                        board.setVisited(v);
                        queue.add(v);
                    }
                }
            }

            Vector<Position> sorted = new Vector<>();
            Position last = positions.remove(positions.size() - 1);
            io.print(last.jumps + " ");
            sorted.add(last);
            while (last.jumps == positions.lastElement().jumps) {
                last = positions.remove(positions.size() - 1);
                sorted.insertElementAt(last, 0);
            }

            Collections.sort(sorted, new Comparator<Position>() {
                @Override
                public int compare(Position o1, Position o2) {
                    if (o1.y == o2.y) {
                        return Integer.compare(o1.x, o2.x);
                    } else {
                        return Integer.compare(o1.y, o2.y);
                    }
                }
            });

            for (Position h: sorted) {
                io.print(h + " ");
            }
            io.println();
        }

        io.close();

    }
}
