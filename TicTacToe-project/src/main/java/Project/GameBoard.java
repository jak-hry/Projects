package Project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameBoard {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        char user1 = 'X';
        char user2 = 'O';

        while (true) {

            int choose1 = 0;
            int chooseMode = selectingAGameMode(choose1);

            if (chooseMode == 1) {

                System.out.println("Podaj nazwe pierwszego uzytkownika");
                String nickName1 = scan.nextLine();
                System.out.println("Podaj nazwe drugiego użytkownika");
                String nickName2 = scan.nextLine();

                char[][] board = new char[3][3];

                while (true) {

                    boolean user1Move = User.performUserMove(board, nickName1, user1);
                    if (!user1Move) {
                        System.out.println(nickName1 + " won");
                        break;
                    }

                    boolean user2Move = User.performUserMove(board, nickName2, user2);
                    if (!user2Move) {
                        System.out.println(nickName2 + " won");
                        break;
                    }
                }

            } else if (chooseMode == 2) {

                System.out.println("Podaj nazwe użytkownika");
                String nickName = scan.nextLine();
                String botName = "computerEasyMode";

                char[][] board = new char[3][3];

                while (true) {

                    boolean userMove = User.performUserMove(board, nickName, user1);
                    if (!userMove) {
                        System.out.println(nickName + " won");
                        break;
                    }

                    boolean computerMove = Computer.performComputerMove(board, botName, user2);
                    if (!computerMove) {
                        System.out.println(botName + " won");
                        break;
                    }
                }
            } else {
                System.out.println("\nwrong number, try again");
                continue;
            }

            boolean choose = choiceOfGameEnding();
            if (!choose) {
                break;
            }

        }
    }

    public static int exceptionSearch(int value) {

        Scanner scan = new Scanner(System.in);
        try {
            value = scan.nextInt();
            scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Exception - " + e + "\n");
            System.out.println("try again");
        }
        return value;
    }

    private static int selectingAGameMode(int choose) {
        Scanner scan = new Scanner(System.in);

        System.out.println("wybierz tryb gry");
        System.out.println("1 - user vs user");
        System.out.println("2 - user vs bot");

        try {
            choose = scan.nextInt();
            scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Exception - " + e);
        }
        return choose;
    }

    private static boolean choiceOfGameEnding() {
        Scanner scan = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {

            System.out.println("You want to play again?");
            System.out.println("1 - Yes");
            System.out.println("2 - No");

            int choose = scan.nextInt();
            scan.nextLine();

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
        return playAgain;
    }

}
