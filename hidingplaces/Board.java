/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.Vector;

public class Board {

    public final int S = 8;
    public boolean[][] board;

    public Board() {
        board = new boolean[S][S];
    }

    public boolean isVisited(Position p) {
        return board[p.y][p.x];
    }

    public void setVisited(Position p) {
        board[p.y][p.x] = true;
    }

    public Vector<Position> getMovesFrom(Position p) {
        Vector<Position> moves = new Vector<>(8);
        if (p.y - 2 >= 0 && p.x - 1 >= 0) { // top left (1)
            moves.add(new Position(p.x - 1, p.y - 2, p.jumps + 1));
        }
        if (p.y - 2 >= 0 && p.x + 1 < S) { // top right (2)
            moves.add(new Position(p.x + 1, p.y - 2, p.jumps + 1));
        }
        if (p.y - 1 >= 0 && p.x - 2 >= 0) { // left top (3)
            moves.add(new Position(p.x - 2, p.y - 1, p.jumps + 1));
        }
        if (p.y - 1 >= 0 && p.x + 2 < S) { // right top (4)
            moves.add(new Position(p.x + 2, p.y - 1, p.jumps + 1));
        }
        if (p.y + 1 < S && p.x - 2 >= 0) { // left bottom (5)
            moves.add(new Position(p.x - 2, p.y + 1, p.jumps + 1));
        }
        if (p.y + 1 < S && p.x + 2 < S) { // right bottom (6)
            moves.add(new Position(p.x + 2, p.y + 1, p.jumps + 1));
        }
        if (p.y + 2 < S && p.x - 1 >= 0) { // bottom left (7)
            moves.add(new Position(p.x - 1, p.y + 2, p.jumps + 1));
        }
        if (p.y + 2 < S && p.x + 1 < S) { // bottom right (8)
            moves.add(new Position(p.x + 1, p.y + 2, p.jumps + 1));
        }
        return moves;
    }

    /*public Vector<Position> getMovesFrom(Position p) {
        Vector<Position> moves = new Vector<>(8);
        if (p.y - 2 >= 0) { // top
            if (p.x - 1 >= 0) { // top left
                moves.add(new Position(p.x - 1, p.y - 2, p.jumps + 1));
            } if (p.x + 1 < S) { // top right
                moves.add(new Position(p.x + 1, p.y - 2, p.jumps + 1));
            }
        } if (p.y + 2 < S) { // bottom
            if (p.x - 1 >= 0) { // bottom left
                moves.add(new Position(p.x - 1, p.y + 2, p.jumps + 1));
            } if (p.x + 1 < S) { // bottom right
                moves.add(new Position(p.x + 1, p.y + 2, p.jumps + 1));
            }
        } if (p.x - 2 >= 0) { // left
            if (p.y - 1 >= 0) { // left top
                moves.add(new Position(p.x - 2, p.y - 1, p.jumps + 1));
            } if (p.y + 1 < S) { // left bottom
                moves.add(new Position(p.x - 2, p.y + 1, p.jumps + 1));
            }
        } if (p.x + 2 < S) { // right
            if (p.y - 1 >= 0) { // right top
                moves.add(new Position(p.x + 2, p.y - 1, p.jumps + 1));
            } if (p.y + 1 < S) { // right bottom
                moves.add(new Position(p.x + 2, p.y + 1, p.jumps + 1));
            }
        }
        return moves;
    }*/

    public String toString() {
        String result = "";
        for (int i = 0; i < S; i++) {
            result += (S - i) + " ";
            for (int j = 0; j < S; j++) {
                if (board[i][j]) {
                    result += "X ";
                } else {
                    result += "O ";
                }
            }
            result += "\n";
        }
        result += "  a b c d e f g h";
        return result;
    }
}
