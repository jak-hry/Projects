package Project;

public class User {

    public static boolean addUser(char[][] board, char symbol) {

        while (true) {

            System.out.println("\nenter the row coordinates ");
            int tempValue1 = 0;
            int row = GameBoard.exceptionSearch(tempValue1);

            if (row >= 3) {
                System.out.println("too high coordinates, try again - " + symbol);
                continue;
            }

            System.out.println("enter the column coordinates ");
            int tempValue2 = 0;
            int column = GameBoard.exceptionSearch(tempValue2);

            if (column >= 3) {
                System.out.println("too high coordinates, try again - " + symbol);
                break;
            }


            if (board[row][column] == 0) {
                board[row][column] = symbol;
                return true;
            } else {
                System.out.println("\nfield occupied, try again - " + symbol);
                Board.printBoard(board);
                addUser(board, symbol);
            }
        }

        return false;
    }

    public static boolean performUserMove(char[][] board, String userName, char symbol) {

        boolean won = false;

        Board.printBoard(board);

        System.out.println("\n" + userName + " your turn - " + symbol);
        boolean userMove = User.addUser(board, symbol);
        if (userMove) {
            won = WinChecking.checking(board, symbol);
        }
        return !won;
    }
}
