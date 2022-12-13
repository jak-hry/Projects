package Project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User {

    private static boolean userMove(char[][] board, char symbol) {

        while (true) {

            Scanner scan = new Scanner(System.in);

            System.out.println("\nenter the row coordinates ");
            int row;
            try {
                row = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Exception - " + e);
                continue;
            }

            if (row >= 3) {
                System.out.println("too high coordinates, try again - " + symbol);
                continue;
            }

            System.out.println("enter the column coordinates ");
            int column;
            try {
                column = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Exception - " + e);
                continue;
            }


            if (column >= 3) {
                System.out.println("too high coordinates, try again - " + symbol);
                break;
            }


            if (board[row][column] == 0) {
                board[row][column] = symbol;
                return true;

            } else if (WinChecking.checking(board, symbol)) {

                System.out.println("\nfield occupied, try again - " + symbol);
                Board.printBoard(board);
                userMove(board, symbol);

            }
        }

        return false;
    }

    public static boolean performUserMove(char[][] board, String userName, char symbol) {

        boolean won = false;

        Board.printBoard(board);

        System.out.println("\n" + userName + " your turn - " + symbol);
        boolean userMove = userMove(board, symbol);
        if (userMove) {
            won = WinChecking.checking(board, symbol);
        }

        return won;
    }
}
