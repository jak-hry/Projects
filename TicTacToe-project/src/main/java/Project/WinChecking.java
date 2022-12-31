package Project;

public class WinChecking {

    public static boolean checking(char[][] board, char symbol) {

        return rowsWinCheck(board, symbol) ||
                columnsWinCheck(board, symbol) ||
                checkFirstBevel(board, symbol) ||
                checkSecondBevel(board, symbol);
    }

    private static boolean rowsWinCheck(char[][] board, char symbol) {

        int size = 3;

        for (int row = 0; row < size; row++) {
            boolean won = true;
            for (int column = 0; column < size; column++) {
                if (board[row][column] != symbol) {
                    won = false;
                    break;
                }
            }

            if (won) {
                return true;
            }
        }

        return false;
    }

    private static boolean columnsWinCheck(char[][] board, char symbol) {

        int size = 3;

        for (int column = 0; column < size; column++) {
            boolean won = true;
            for (int row = 0; row < size; row++) {
                if (board[row][column] != symbol) {
                    won = false;
                    break;
                }
            }

            if (won) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkFirstBevel(char[][] board, char symbol) {

        int size = 3;

        for (int i = 0; i < size; i++) {
            if (board[i][i] != symbol) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkSecondBevel(char[][] board, char symbol) {

        int size = 3;

        for (int i = 0; i < size; i++) {
            if (board[size - i - 1][i] != symbol) {
                return false;
            }
        }

        return true;
    }

    public static boolean drawCheck(char[][] board) {

        int size = 3;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        System.out.println("\ndraw, nobody wins");
        return true;
    }

}
