package Statistics;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Statistics {

    public static void main(String[] args) {

        int sumOfWins1, sumOfWins2, sumOfWins3, totalWins;
        float winPercentage1, winPercentage2, winPercentage3, winPercentage4, winPercentage5, winPercentage6;

        File file1 = new File("/Users/Jakub/dev/projects/TicTacToe-project/src/main/java/Statistics/Files/userVsUserWinCounter1");
        int size1 = Math.toIntExact(file1.length());

        File file2 = new File("/Users/Jakub/dev/projects/TicTacToe-project/src/main/java/Statistics/Files/userVsUserWinCounter2");
        int size2 = Math.toIntExact(file2.length());

        File file3 = new File("/Users/Jakub/dev/projects/TicTacToe-project/src/main/java/Statistics/Files/userVsComputerEasyModeWinCounter1");
        int size3 = Math.toIntExact(file3.length());

        File file4 = new File("/Users/Jakub/dev/projects/TicTacToe-project/src/main/java/Statistics/Files/userVsComputerEasyModeWinCounter2");
        int size4 = Math.toIntExact(file4.length());

        File file5 = new File("/Users/Jakub/dev/projects/TicTacToe-project/src/main/java/Statistics/Files/userVsComputerMediumModeWinCounter1");
        int size5 = Math.toIntExact(file5.length());

        File file6 = new File("/Users/Jakub/dev/projects/TicTacToe-project/src/main/java/Statistics/Files/userVsComputerMediumModeWinCounter2");
        int size6 = Math.toIntExact(file6.length());

        sumOfWins1 = size1 + size2;
        sumOfWins2 = size3 + size4;
        sumOfWins3 = size5 + size6;
        totalWins = sumOfWins1 + sumOfWins2 + sumOfWins3;
        winPercentage1 = calculatePercentage(size1, sumOfWins1);
        winPercentage2 = calculatePercentage(size2, sumOfWins1);
        winPercentage3 = calculatePercentage(size3, sumOfWins2);
        winPercentage4 = calculatePercentage(size4, sumOfWins2);
        winPercentage5 = calculatePercentage(size5, sumOfWins3);
        winPercentage6 = calculatePercentage(size6, sumOfWins3);

        System.out.println("----------------------------------------------------");
        System.out.println("\n\t\t\t\t  user VS user\n");
        System.out.println("\t\t\tuser1 number of wins is: " + size1);
        System.out.println("\t\t\tpercent won: " + winPercentage1 + "%\n");
        System.out.println("\t\t\tuser2 number of wins is: " + size2);
        System.out.println("\t\t\tpercent won: " + winPercentage2 + "%\n");
        System.out.println("\t\t\tthe sum of games played is: " + sumOfWins1 + "\n");
        System.out.println("----------------------------------------------------");
        System.out.println("\n\t\t\tuser VS computerEasyMode\n");
        System.out.println("\t\t\tuser number of wins is: " + size3);
        System.out.println("\t\t\tpercent won: " + winPercentage3 + "%\n");
        System.out.println("\t\t\tcomputer number of wins is: " + size4);
        System.out.println("\t\t\tpercent won: " + winPercentage4 + "%\n");
        System.out.println("\t\t\tthe sum of games played is: " + sumOfWins2 + "\n");
        System.out.println("----------------------------------------------------");
        System.out.println("\n\t\t\tuser VS computerMediumMode\n");
        System.out.println("\t\t\tuser number of wins is: " + size5);
        System.out.println("\t\t\tpercent won: " + winPercentage5 + "%\n");
        System.out.println("\t\t\tcomputer number of wins is: " + size6);
        System.out.println("\t\t\tpercent won: " + winPercentage6 + "%\n");
        System.out.println("\t\t\tthe sum of games played is: " + sumOfWins3 + "\n");
        System.out.println("----------------------------------------------------");
        System.out.println("\n\t\tthe total number of games played is: " + totalWins + "\n");
        System.out.println("----------------------------------------------------");

    }

    private static float calculatePercentage(float obtained, float total) {
        return obtained * 100 / total;
    }

    public static void userVsUserWinCounter1() throws IOException {

        String fileName = "/Users/Jakub/dev/projects/TicTacToe-project/src/main/java/Statistics/Files/userVsUserWinCounter1";
        winCounter(fileName);

    }

    public static void userVsUserWinCounter2() throws IOException {

        String fileName = "/Users/Jakub/dev/projects/TicTacToe-project/src/main/java/Statistics/Files/userVsUserWinCounter2";
        winCounter(fileName);

    }

    public static void userVsComputerEasyModeWinCounter1() throws IOException {

        String fileName = "/Users/Jakub/dev/projects/TicTacToe-project/src/main/java/Statistics/Files/userVsComputerEasyModeWinCounter1";
        winCounter(fileName);

    }

    public static void userVsComputerEasyModeWinCounter2() throws IOException {

        String fileName = "/Users/Jakub/dev/projects/TicTacToe-project/src/main/java/Statistics/Files/userVsComputerEasyModeWinCounter2";
        winCounter(fileName);

    }

    public static void userVsComputerMediumModeWinCounter1() throws IOException {

        String fileName = "/Users/Jakub/dev/projects/TicTacToe-project/src/main/java/Statistics/Files/userVsComputerMediumModeWinCounter1";
        winCounter(fileName);

    }

    public static void userVsComputerMediumModeWinCounter2() throws IOException {

        String fileName = "/Users/Jakub/dev/projects/TicTacToe-project/src/main/java/Statistics/Files/userVsComputerMediumModeWinCounter2";
        winCounter(fileName);

    }

    private static void winCounter(String fileName) throws IOException {

        File file = new File(fileName);
        file.createNewFile();

        Scanner scan;

        scan = new Scanner(file);
        ArrayList<String> arrayList = new ArrayList<>();
        while (scan.hasNextLine()) {
            arrayList.add(scan.nextLine());
        }
        scan.close();

        PrintStream printStream = new PrintStream(file);

        for (String s : arrayList) {
            printStream.print(s);
        }

        printStream.print("w");
        printStream.close();

    }
}
