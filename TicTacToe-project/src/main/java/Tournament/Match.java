package Tournament;

import java.io.Serializable;
import java.util.Arrays;

import static Project.Board.printBoard;
import static Project.User.performUserMove;

public class Match implements Serializable {

    public static boolean playAMatch(String player1, String player2) {

        boolean won;
        char user1 = 'X';
        char user2 = 'O';

        char[][] board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }

        while (true) {

            boolean endOfGame1 = performUserMove(board, player1, user1);
            if (endOfGame1) {
                won = true;
                printBoard(board);
                break;
            }
            boolean endOfGame2 = performUserMove(board, player2, user2);
            if (endOfGame2) {
                won = false;
                printBoard(board);
                break;
            }

        }

        return won;
    }
}
