package Project;

import GameStats.Result;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import static GameStats.Counter.*;
import static Project.Board.printBoard;
import static Project.Computer.performComputerMediumModeMove;
import static Project.Computer.performComputerMove;
import static Project.User.performUserMove;
import static Project.WinChecking.drawCheck;

public class GameBoard implements Serializable {

    public static void main(String[] args) {

        String fileName = "statisticsMap.txt";

        Scanner scan = new Scanner(System.in);
        char user1 = 'X';
        char user2 = 'O';

        if (readHashMapWithObject(fileName) == null){
            writeStatsHashMap();
        }

        HashMap<String, Result> map = readHashMapWithObject(fileName);

        while (true) {

            int chooseMode = selectingAGameMode();

            if (chooseMode == 1) {

                playerVsPlayerMatch(scan, user1, user2, map);

            } else if (chooseMode == 2) {

                int chooseDifficulty = selectingADifficultyLevel();

                if (chooseDifficulty == 1) {

                    playerVsComputerEasyModeMatch(scan, user1, user2, map);

                } else if (chooseDifficulty == 2) {

                    playerVsComputerMediumModeMatch(scan, user1, user2, map);

                } else {
                    System.out.println("\nwrong number, try again\n");
                    continue;
                }

            } else {
                System.out.println("\nwrong number, try again");
                continue;
            }

            writeStatsHashMapToObject(map, fileName);

            boolean choose = choiceOfGameEnding();
            if (!choose) {
                break;
            }
        }

    }

    private static void playerVsPlayerMatch(Scanner scan, char user1, char user2, HashMap<String, Result> map) {

        System.out.println("Enter the name of the first user");
        String nickName1 = scan.nextLine();
        System.out.println("Enter the name of the second user");
        String nickName2 = scan.nextLine();

        char[][] board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }

        while (true) {

            boolean endOfGame1 = performUserMove(board, nickName1, user1);
            if (endOfGame1) {
                incrementFirstCounter(map);
                printBoard(board);
                break;
            }
            if (drawCheck(board)){
                break;
            }
            boolean endOfGame2 = performUserMove(board, nickName2, user2);
            if (endOfGame2) {
                incrementSecondCounter(map);
                printBoard(board);
                break;
            }
            if (drawCheck(board)){
                break;
            }
        }
    }

    private static void playerVsComputerEasyModeMatch(Scanner scan, char user1, char user2, HashMap<String, Result> map) {

        System.out.println("Enter username");
        String nickName = scan.nextLine();
        String botName = "computerEasyMode";

        char[][] board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }

        while (true) {

            boolean endOfGame1 = performUserMove(board, nickName, user1);
            if (endOfGame1) {
                incrementThirdCounter(map);
                printBoard(board);
                break;
            }
            if (drawCheck(board)){
                break;
            }
            boolean endOfGame2 = performComputerMove(board, botName, user2);
            if (endOfGame2) {
                incrementFourthCounter(map);
                printBoard(board);
                break;
            }
            if (drawCheck(board)){
                break;
            }
        }
    }

    private static void playerVsComputerMediumModeMatch(Scanner scan, char user1, char user2, HashMap<String, Result> map) {

        System.out.println("Enter username");
        String nickName = scan.nextLine();
        String botName = "computerMediumMode";

        char[][] board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }

        while (true) {

            boolean endOfGame1 = performUserMove(board, nickName, user1);
            if (endOfGame1) {
                incrementFifthCounter(map);
                printBoard(board);
                break;
            }
            if (drawCheck(board)){
                break;
            }
            boolean endOfGame2 = performComputerMediumModeMove(board, botName, user2);
            if (endOfGame2) {
                incrementSixthCounter(map);
                printBoard(board);
                break;
            }
            if (drawCheck(board)){
                break;
            }
        }
    }

    private static int selectingAGameMode() {

        Scanner scan = new Scanner(System.in);
        int choose = 0;

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

    private static int selectingADifficultyLevel() {

        Scanner scan = new Scanner(System.in);
        int choose = 0;

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

            System.out.println("\nYou want to play again?");
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