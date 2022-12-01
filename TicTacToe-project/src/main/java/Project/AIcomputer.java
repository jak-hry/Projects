package Project;

import java.util.Random;

public class AIcomputer {

    public static boolean addComputerEasyMode(char[][] board, char symbol) {

        Random random = new Random();

        int row = random.nextInt(3);
        int column = random.nextInt(3);

        if (board[row][column] == 0) {
            board[row][column] = symbol;

            return true;

        }

        return false;
    }
}
