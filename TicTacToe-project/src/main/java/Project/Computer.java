package Project;

import java.util.Random;

public class Computer {

    public static boolean addComputerEasyMode(char[][] board, char symbol) {

        Random random = new Random();

        int row = random.nextInt(3);
        int column = random.nextInt(3);

        if (board[row][column] == 0) {
            board[row][column] = symbol;
            return true;

        } else {
            addComputerEasyMode(board, symbol);
        }

        return false;
    }

    public static boolean performComputerMove(char[][] board, String computerMode, char symbol) {

        boolean won = false;

        Board.printBoard(board);

        System.out.println("\n" + computerMode + " your turn - " + symbol);
        boolean computerMove = Computer.addComputerEasyMode(board, symbol);
        if (computerMove){
            won = WinChecking.checking(board, symbol);
        }
        return !won;
    }
}
