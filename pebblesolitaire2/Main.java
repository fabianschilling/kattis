/**
* @author Fabian Schilling (fabsch@kth.se)
*/

// naive solution

import java.util.HashMap;

public class Main {

    public static int mincount;
    public static HashMap<String, Integer> map;

    public static int solve(char[] board, int count) {

        String b = new String(board);

        if (map.containsKey(b)) {
            return map.get(b);
        }

        char[] newBoard = board.clone();

        for (int i = 0; i < board.length - 2; i++) {
            if (board[i] == 'o' && board[i + 1] == 'o' && board[i + 2] == '-') {
                board[i] = '-';
                board[i + 1] = '-';
                board[i + 2] = 'o';
                map.put(b, solve(board, count - 1));
                board = newBoard.clone();
            }
            if (board[i] == '-' && board[i + 1] == 'o' && board[i + 2] == 'o') {
                board[i] = 'o';
                board[i + 1] = '-';
                board[i + 2] = '-';
                map.put(b, solve(board, count - 1));
                board = newBoard.clone();
            }
        }

        if (count < mincount) {
            mincount = count;
        }

        return mincount;
    }

    public static void main(String[] args) {

        IO io = new IO(System.in, System.out);

        int n = io.getInt();

        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mincount = Integer.MAX_VALUE;
            char[] board = io.getWord().toCharArray();
            int count = 0;
            for (char c : board) {
                if (c == 'o') {
                    count++;
                }
            }
            map.clear();
            //io.println(b);
            io.println(solve(board, count));

        }

        io.close();
    }
}
