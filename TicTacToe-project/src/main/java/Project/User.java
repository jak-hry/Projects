package Project;

import java.util.Scanner;

public class User {

    public static boolean addUser(char[][] board, char symbol) {

        Scanner scan = new Scanner(System.in);

        System.out.println("enter the row coordinates");
        int row = scan.nextInt();
        System.out.println("enter column coordinates");
        int column = scan.nextInt();

        if (board[row][column] == 0) {
            board[row][column] = symbol;
            return true;
        } else {
            System.out.println("wrong move, try again");
        }

        return false;
    }
}
