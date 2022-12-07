package Project;

import Statistics.Statistics;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameBoard {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        char user1 = 'X';
        char user2 = 'O';

        while (true) {

            int choose1 = 0;
            int chooseMode = selectingAGameMode(choose1);

            if (chooseMode == 1) {

                System.out.println("Enter the name of the first user");
                String nickName1 = scan.nextLine();
                System.out.println("Enter the name of the second user");
                String nickName2 = scan.nextLine();

                char[][] board = new char[3][3];

                while (true) {

                    boolean endOfGame1 = User.performUserMove(board, nickName1, user1);
                    if (endOfGame1) {
                        Statistics.userVsUserWinCounter1();
                        break;
                    }
                    boolean endOfGame2 = User.performUserMove(board, nickName2, user2);
                    if (endOfGame2) {
                        Statistics.userVsUserWinCounter2();
                        break;
                    }

                }

            } else if (chooseMode == 2) {

                int choose2 = 0;
                int chooseDifficulty = selectingADifficultyLevel(choose2);

                if (chooseDifficulty == 1) {

                    System.out.println("Enter username");
                    String nickName = scan.nextLine();
                    String botName = "computerEasyMode";

                    char[][] board = new char[3][3];

                    while (true) {

                        boolean endOfGame1 = User.performUserMove(board, nickName, user1);
                        if (endOfGame1) {
                            Statistics.userVsComputerEasyModeWinCounter1();
                            break;
                        }
                        boolean endOfGame2 = Computer.performComputerMove(board, botName, user2);
                        if (endOfGame2) {
                            Statistics.userVsComputerEasyModeWinCounter2();
                            break;
                        }
                    }
                } else if (chooseDifficulty == 2) {

                    System.out.println("Enter username");
                    String nickName = scan.nextLine();
                    String botName = "computerMediumMode";

                    char[][] board = new char[3][3];

                    while (true) {

                        boolean endOfGame1 = User.performUserMove(board, nickName, user1);
                        if (endOfGame1) {
                            Statistics.userVsComputerMediumModeWinCounter1();
                            break;
                        }
                        boolean endOfGame2 = Computer.performComputerMediumModeMove(board, botName, user2);
                        if (endOfGame2) {
                            Statistics.userVsComputerMediumModeWinCounter2();
                            break;
                        }
                    }

                } else {
                    System.out.println("\nwrong number, try again\n");
                    continue;
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

    private static int selectingAGameMode(int choose) {
        Scanner scan = new Scanner(System.in);

        System.out.println("select a game mode");
        System.out.println("1 - user vs user");
        System.out.println("2 - user vs bot");

        try {
            choose = scan.nextInt();
            scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("\nException - " + e);
        }
        return choose;
    }

    private static int selectingADifficultyLevel(int choose) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose the difficulty level");
        System.out.println("1 - Easy level");
        System.out.println("2 - Medium level");

        try {
            choose = scan.nextInt();
            scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("\nException - " + e);
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
