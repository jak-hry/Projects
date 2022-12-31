package Tournament;

import java.io.Serializable;
import java.util.Arrays;

import static Project.Board.printBoard;
import static Project.User.performUserMove;

public class Match implements Serializable {

    public static boolean playAMatch(String player1, String player2) {

        char user1 = 'X';
        char user2 = 'O';

        while (true) {
            char[][] board = new char[3][3];
            for (char[] chars : board) {
                Arrays.fill(chars, ' ');
            }

            while (true) {

                boolean endOfGame1 = performUserMove(board, player1, user1);
                if (endOfGame1) {
                    printBoard(board);
                    return true;
                }
                if (drawCheck(board)) {
                    break;
                }
                boolean endOfGame2 = performUserMove(board, player2, user2);
                if (endOfGame2) {
                    printBoard(board);
                    return false;
                }
                if (drawCheck(board)) {
                    break;
                }
            }
        }

    }

    private static boolean drawCheck(char[][] board) {

        int size = 3;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        System.out.println("\ndraw, nobody wins, let's play again!");
        return true;
    }

}
