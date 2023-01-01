package Project;

import java.util.Random;

import static Project.Board.printBoard;
import static Project.WinChecking.checking;

public class Computer {

    private static boolean computerEasyModeMove(char[][] board, char symbol) {

            Random random = new Random();

            while (true) {

                int row = random.nextInt(3);
                int column = random.nextInt(3);

                if (board[row][column] == ' ') {
                    board[row][column] = symbol;
                    return true;

                } else {
                    computerEasyModeMove(board, symbol);
                    break;
                }
            }

        return false;
    }

    private static boolean computerMediumModeMove(char[][] board, char symbol) {

        int size = 3;
        int counterX, counterO;
        char userSymbol = 'X';
        boolean move = true;

        while (move) {

            for (int row = 0; row < size; row++) {
                counterO = 0;
                counterX = 0;
                for (int column = 0; column < size; column++) {
                    if (board[row][column] == userSymbol) {
                        counterX++;
                    } else if (board[row][column] == symbol) {
                        counterO++;
                    }
                }

                if (counterX == 2 && counterO == 0) {
                    for (int column = 0; column < size; column++) {
                        if (board[row][column] == ' ') {
                            board[row][column] = symbol;
                            move = false;
                        }
                    }
                }
            }

            if (!move) {
                break;
            }

            for (int column = 0; column < size; column++) {
                counterO = 0;
                counterX = 0;
                for (int row = 0; row < size; row++) {
                    if (board[row][column] == userSymbol) {
                        counterX++;
                    } else if (board[row][column] == symbol) {
                        counterO++;
                    }
                }

                if (counterX == 2 && counterO == 0) {
                    for (int row = 0; row < size; row++) {
                        if (board[row][column] == ' ') {
                            board[row][column] = symbol;
                            move = false;
                        }
                    }
                }
            }

            if (!move) {
                break;
            }

            counterO = 0;
            counterX = 0;
            for (int i = 0; i < size; i++) {
                if (board[i][i] == userSymbol) {
                    counterX++;
                } else if (board[i][i] == symbol) {
                    counterO++;
                }

                if (counterX == 2 && counterO == 0) {
                    for (int j = 0; j < size; j++) {
                        if (board[j][j] == ' ') {
                            board[j][j] = symbol;
                            move = false;
                        }
                    }
                }
            }

            if (!move) {
                break;
            }

            counterO = 0;
            counterX = 0;
            for (int i = 0; i < size; i++) {
                if (board[size - i - 1][i] == userSymbol) {
                    counterX++;
                } else if (board[size - i - 1][i] == symbol) {
                    counterO++;
                }

                if (counterX == 2 && counterO == 0) {
                    for (int j = 0; j < size; j++) {
                        if (board[size - j - 1][j] == ' ') {
                            board[size - j - 1][j] = symbol;
                            move = false;
                        }
                    }
                }
            }

            if (move) {
                computerEasyModeMove(board, symbol);
                return true;
            } else {
                break;
            }
        }

        return false;
    }

    public static boolean performComputerMove(char[][] board, String computerMode, char symbol) {

        boolean won = false;

        printBoard(board);

        System.out.println("\n" + computerMode + " turn - " + symbol);
        boolean computerMove = computerEasyModeMove(board, symbol);
        if (computerMove) {
            won = checking(board, symbol);
        }

        return won;
    }

    public static boolean performComputerMediumModeMove(char[][] board, String computerMode, char symbol) {

        boolean won = false;

        printBoard(board);

        System.out.println("\n" + computerMode + " your turn - " + symbol);
        boolean computerMove = computerMediumModeMove(board, symbol);
        if (computerMove) {
            won = checking(board, symbol);
        }

        return won;
    }

}
