package Project;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Project.Board.printBoard;
import static Project.WinChecking.checking;

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
                System.out.println("\ntoo high coordinates, try again - " + symbol);
                printBoard(board);
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
                System.out.println("\ntoo high coordinates, try again - " + symbol);
                printBoard(board);
                continue;
            }


            if (board[row][column] == ' ') {
                board[row][column] = symbol;
                return true;

            } else {

                System.out.println("\nfield occupied, try again - " + symbol);
                printBoard(board);
                userMove(board, symbol);
                break;
            }
        }

        return false;
    }

    public static boolean performUserMove(char[][] board, String userName, char symbol) {

        boolean won = false;

        printBoard(board);

        System.out.println("\n" + userName + " your turn - " + symbol);
        boolean userMove = userMove(board, symbol);
        if (userMove) {
            won = checking(board, symbol);
        }

        return won;
    }
}
