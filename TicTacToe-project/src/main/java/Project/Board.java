package Project;

import java.util.Arrays;

public class Board {

    public static void printBoard(char[][] board) {

        System.out.println();
        System.out.println("\t0" + "\t1" + "\t2");

        for (int row = 0; row < board.length; row++) {
            System.out.print(row + ":\t");
            for (int column = 0; column < board[row].length; column++) {
                System.out.print(board[row][column] + "\t");
            }
            System.out.println();
        }
    }
}
