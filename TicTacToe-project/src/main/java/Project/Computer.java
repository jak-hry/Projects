package Project;

import java.util.Random;

public class Computer {

    private static boolean computerEasyModeMove(char[][] board, char symbol) {

        Random random = new Random();

        int row = random.nextInt(3);
        int column = random.nextInt(3);

        if (board[row][column] == 0) {
            board[row][column] = symbol;
            return true;

        } else {
            computerEasyModeMove(board, symbol);
        }

        return false;
    }

    private static boolean computerMediumModeMove(char[][] board, char symbol) {

        int size = 3;
        int counterX, counterO;
        char user1 = 'X';
        boolean move = true;

        while (move) {
            for (int row = 0; row < size; row++) {
                counterX = 0;
                counterO = 0;
                for (int column = 0; column < size; column++) {
                    if (board[row][column] == user1) {
                        counterX++;
                    } else if (board[row][column] == symbol) {
                        counterO++;
                    }
                }

                if (counterX == 2 && counterO == 0) {
                    for (int column = 0; column < size; column++) {
                        if (board[row][column] == '0') {
                            board[row][column] = symbol;
                            move = false;
                        }
                    }
                }
            }

            for (int column = 0; column < size; column++) {
                counterX = 0;
                counterO = 0;
                for (int row = 0; row < size; row++) {
                    if (board[row][column] == user1) {
                        counterX++;
                    } else if (board[row][column] == symbol) {
                        counterO++;
                    }
                }

                if (counterX == 2 && counterO == 0) {
                    for (int row = 0; row < size; row++) {
                        if (board[row][column] == '0') {
                            board[row][column] = symbol;
                            move = false;
                        }
                    }
                }
            }

            if (move) {
                computerEasyModeMove(board, symbol);
                return true;
            }
        }

        return false;
    }

    public static boolean performComputerMove(char[][] board, String computerMode, char symbol) {

        boolean won = false;

        Board.printBoard(board);

        System.out.println("\n" + computerMode + " turn - " + symbol);
        boolean computerMove = computerEasyModeMove(board, symbol);
        if (computerMove) {
            won = WinChecking.checking(board, symbol);
        }

        return won;
    }

    public static boolean performComputerMediumModeMove(char[][] board, String computerMode, char symbol) {

        boolean won = false;

        Board.printBoard(board);

        System.out.println("\n" + computerMode + " your turn - " + symbol);
        boolean computerMove = Computer.computerMediumModeMove(board, symbol);
        if (computerMove) {
            won = WinChecking.checking(board, symbol);
        }

        return won;
    }
}
