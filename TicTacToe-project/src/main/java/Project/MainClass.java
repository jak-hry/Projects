package Project;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean playAgain = true;
        char user1 = 'X';
        char user2 = 'O';
        boolean won1 = false;
        boolean won2 = false;

        while (playAgain) {

            System.out.println("wybierz tryb gry");
            System.out.println("1 - user vs user");
            System.out.println("2 - user vs bot");

            int chooseDifficulty = scan.nextInt();

            if (chooseDifficulty == 1) {

                System.out.println("Podaj nazwe pierwszego uzytkownika");
                String nickName1 = scan.nextLine();
                System.out.println("Podaj nazwe drugiego użytkownika");
                String nickName2 = scan.nextLine();

                char[][] board = new char[3][3];

                while (true) {

                    Board.printBoard(board);
                    System.out.println("\n" + nickName1 + " your turn - " + user1);
                    boolean move1 = User.addUser(board, user1);
                    if (move1) {
                        won1 = WinChecking.checking(board, user1);
                    }
                    if (won1) {
                        break;
                    }

                    Board.printBoard(board);
                    System.out.println("\n" + nickName2 + " your turn - " + user2);
                    boolean move2 = User.addUser(board, user2);
                    if (move2) {
                        won2 = WinChecking.checking(board, user2);
                    }
                    if (won2) {
                        break;
                    }

                }

            } else if (chooseDifficulty == 2) {

                System.out.println("Podaj nazwe użytkownika");
                String nickName = scan.nextLine();
                String botName = "computerEasyMode";

                char[][] board = new char[3][3];

                while (true) {

                    Board.printBoard(board);
                    System.out.println("\n" + nickName + " your turn - " + user1);
                    boolean move1 = User.addUser(board, user1);
                    if (move1) {
                        won1 = WinChecking.checking(board, user1);
                    }
                    if (won1) {
                        break;
                    }


                    System.out.println("\n" + botName + " your turn - " + user2);
                    boolean move2 = AIcomputer.addComputerEasyMode(board, user2);
                    if (move2) {
                        won2 = WinChecking.checking(board, user2);
                    }
                    if (won2) {
                        break;
                    }

                    Board.printBoard(board);

                }
            } else {
                System.out.println("\ntry again");
                continue;
            }

            while (playAgain) {

                System.out.println("You want to play again?");
                System.out.println("1 - Yes");
                System.out.println("2 - No");

                int choose = scan.nextInt();

                if (choose == 1) {
                    System.out.println("\nLet's go to play again!\n");
                    break;
                } else if (choose == 2) {
                    System.out.println("\nThanks for using!");
                    playAgain = false;
                } else {
                    System.out.println("\nTry again\n");
                    continue;
                }

                System.out.println();
            }

        }

    }
}
