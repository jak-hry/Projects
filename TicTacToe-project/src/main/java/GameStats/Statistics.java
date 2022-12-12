package GameStats;

import java.util.HashMap;

public class Statistics {

    public static void main(String[] args) {

        int result1, result2, result3, result4, result5, result6;
        int sumOfWins1, sumOfWins2, sumOfWins3, totalWins;
        float winPercentage1, winPercentage2, winPercentage3, winPercentage4, winPercentage5, winPercentage6;

        HashMap<String, Result> testingMap = Counter.readHashMapWithObject();

        result1 = getPlayer1Wins("PVP", testingMap);
        result2 = getPlayer2Wins("PVP", testingMap);
        result3 = getPlayer1Wins("PVC1", testingMap);
        result4 = getPlayer2Wins("PVC1", testingMap);
        result5 = getPlayer1Wins("PVC2", testingMap);
        result6 = getPlayer2Wins("PVC2", testingMap);

        sumOfWins1 = result1 + result2;
        sumOfWins2 = result3 + result4;
        sumOfWins3 = result5 + result6;
        totalWins = sumOfWins1 + sumOfWins2 + sumOfWins3;
        winPercentage1 = calculatePercentage(result1, sumOfWins1);
        winPercentage2 = calculatePercentage(result2, sumOfWins1);
        winPercentage3 = calculatePercentage(result3, sumOfWins2);
        winPercentage4 = calculatePercentage(result4, sumOfWins2);
        winPercentage5 = calculatePercentage(result5, sumOfWins3);
        winPercentage6 = calculatePercentage(result6, sumOfWins3);

        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("\n\t\t\t\t  user VS user\n");
        System.out.println("\t\t\tuser1 number of wins is: " + result1);
        System.out.println("\t\t\tpercent won: " + winPercentage1 + "%\n");
        System.out.println("\t\t\tuser2 number of wins is: " + result2);
        System.out.println("\t\t\tpercent won: " + winPercentage2 + "%\n");
        System.out.println("\t\t\tthe sum of games played is: " + sumOfWins1 + "\n");
        System.out.println("----------------------------------------------------");
        System.out.println("\n\t\t\tuser VS computerEasyMode\n");
        System.out.println("\t\t\tuser number of wins is: " + result3);
        System.out.println("\t\t\tpercent won: " + winPercentage3 + "%\n");
        System.out.println("\t\t\tcomputer number of wins is: " + result4);
        System.out.println("\t\t\tpercent won: " + winPercentage4 + "%\n");
        System.out.println("\t\t\tthe sum of games played is: " + sumOfWins2 + "\n");
        System.out.println("----------------------------------------------------");
        System.out.println("\n\t\t\tuser VS computerMediumMode\n");
        System.out.println("\t\t\tuser number of wins is: " + result5);
        System.out.println("\t\t\tpercent won: " + winPercentage5 + "%\n");
        System.out.println("\t\t\tcomputer number of wins is: " + result6);
        System.out.println("\t\t\tpercent won: " + winPercentage6 + "%\n");
        System.out.println("\t\t\tthe sum of games played is: " + sumOfWins3 + "\n");
        System.out.println("----------------------------------------------------");
        System.out.println("\n\t\tthe total number of games played is: " + totalWins + "\n");
        System.out.println("----------------------------------------------------");

    }

    private static int getPlayer1Wins(String modeName, HashMap<String, Result> map) {

        Result result = map.get(modeName);
        return result.getPlayer1Wins();
    }

    private static int getPlayer2Wins(String modeName, HashMap<String, Result> map) {

        Result result = map.get(modeName);
        return result.getPlayer2Wins();
    }

    private static float calculatePercentage(float obtained, float total) {
        return obtained * 100 / total;
    }

}

