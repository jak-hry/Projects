package Project;

public class WinChecking {

    public static boolean checking(char[][] board, char symbol) {

        return rowsWinCheck(board, symbol) ||
                columnsWinCheck(board, symbol) ||
                checkFirstBevel(board, symbol) ||
                checkSecondBevel(board, symbol);
    }

    public static boolean rowsWinCheck(char[][] board, char symbol) {

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

    public static boolean columnsWinCheck(char[][] board, char symbol) {

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

    public static boolean checkFirstBevel(char[][] board, char symbol) {

        int size = 3;

        for (int i = 0; i < size; i++) {
            if (board[i][i] != symbol) {
                return false;
            }
        }

        return true;

    }

    public static boolean checkSecondBevel(char[][] board, char symbol) {

        int size = 3;

        for (int i = 0; i < size; i++) {
            if (board[size - i - 1][i] != symbol) {
                return false;
            }
        }

        return true;
    }

}
