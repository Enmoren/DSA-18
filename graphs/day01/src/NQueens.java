import java.util.ArrayList;
import java.util.List;

public class NQueens {


    /**
     * Checks the 45° and 135° diagonals for an existing queen. For example, if the board is a 5x5
     * and you call checkDiagonal(board, 3, 1), The positions checked for an existing queen are
     * marked below with an `x`. The location (3, 1) is marked with an `o`.
     *
     * ....x
     * ...x.
     * x.x..
     * .o...
     * .....
     *
     * Returns true if a Queen is found.
     *
     * Do not modify this function (the tests use it)
     */


    //Time: O (N!*N^2)
    //Space: N^2
    public static boolean checkDiagonal(char[][] board, int r, int c) {
        int y = r - 1;
        int x = c - 1;
        while (y >= 0 && x >= 0) {
            if (board[y][x] == 'Q') return true;
            x--;
            y--;
        }
        y = r - 1;
        x = c + 1;
        while (y >= 0 && x < board[0].length) {
            if (board[y][x] == 'Q') return true;
            x++;
            y--;
        }
                y = r + 1;
        x = c + 1;
        while (y < board[0].length && x < board[0].length) {
            if (board[y][x] == 'Q') return true;
            x++;
            y++;
        }
        y = r + 1;
        x = c - 1;
        while (y < board[0].length && x >= 0) {
            if (board[y][x] == 'Q') return true;
            x--;
            y++;
        }
        return false;
    }

//    public static boolean checkDiagonal(char[][] board, int r, int c) {
//        int y = r - 1;
//        int x = c - 1;
//        while (y >= 0 && x >= 0) {
//            if (board[y][x] == 'Q') return false;
//            x--;
//            y--;
//        }
//        y = r - 1;
//        x = c + 1;
//        while (y >= 0 && x < board[0].length) {
//            if (board[y][x] == 'Q') return false;
//            x++;
//            y--;
//        }
//        y = r + 1;
//        x = c + 1;
//        while (y < board[0].length && x < board[0].length) {
//            if (board[y][x] == 'Q') return false;
//            x++;
//            y++;
//        }
//        y = r + 1;
//        x = c - 1;
//        while (y < board[0].length && x >= 0) {
//            if (board[y][x] == 'Q') return false;
//            x--;
//            y++;
//        }
//        return true;
//    }

    public static boolean checkRow(char[][] board, int r, int c){
        int x = c;
        while ( x >= 0){
            if (board[r][x] == 'Q') return false;
            x--;
        }
        x = c;
        while ( x < board[0].length){
            if (board[r][x] == 'Q') return false;
            x++;
        }
        return true;
    }

    private static boolean checkCol(char[][] board, int r, int c) {
        int y = r;
        while (y >= 0) {
            if (board[y][c] == 'Q') return false;
            y--;
        }
        y = r;
        while (y < board[0].length) {
            if (board[y][c] == 'Q') return false;
            y++;
        }
        return true;
    }


    /**
     * Creates a deep copy of the input array and returns it
     */
    private static char[][] copyOf(char[][] A) {
        char[][] B = new char[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, B[i], 0, A[0].length);
        return B;
    }

    public static List<char[][]> nQueensSolutions(int n) {
        List<char[][]> answers = new ArrayList<>();
        char[][] current = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                current[i][j] = '.';
            }
        }
        solve(answers, current, n, 0, 0);
        return answers;
    }
    public static void solve(List<char[][]> solutions, char[][] current, int numQueen, int row, int col){

        if (numQueen == 0) {
            solutions.add(copyOf(current));
        }

        else {
            for (int i = 0; i < current[0].length; i++) {
                if (isvalid(current, i, col)) {
                    current[i][col] = 'Q';
                    solve(solutions, current, numQueen - 1, i, col + 1);
                    current[i][col] = '.';
                }
            }
        }

    }
    public static boolean isvalid(char[][] board, int row, int col) {
        if (!checkCol(board, row, col)){
            return false;
        }
        if (!checkRow(board, row, col)){
            return false;
        }
        if (checkDiagonal(board,row,col)){
            return false;
        }
        return true;
    }
}
