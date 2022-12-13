package GameStats;

import java.util.ArrayList;
import java.util.HashMap;

public class Statistics {

    public static void main(String[] args) {

        System.out.println("\n----------------------------------------------------");
        System.out.println("\n\t\t\t\t player VS player\n");
        System.out.println("\t\t\tuser1 number of wins is: " + getResults().get(0));
        System.out.println("\t\t\tpercent won: " + getWinPercentage().get(0) + "%\n");
        System.out.println("\t\t\tuser2 number of wins is: " + getResults().get(1));
        System.out.println("\t\t\tpercent won: " + getWinPercentage().get(1) + "%\n");
        System.out.println("\t\t\tthe sum of games played is: " + getSumOfWins().get(0) + "\n");
        System.out.println("----------------------------------------------------");
        System.out.println("\n\t\t\tplayer VS computerEasyMode\n");
        System.out.println("\t\t\tuser number of wins is: " + getResults().get(2));
        System.out.println("\t\t\tpercent won: " + getWinPercentage().get(2) + "%\n");
        System.out.println("\t\t\tcomputer number of wins is: " + getResults().get(3));
        System.out.println("\t\t\tpercent won: " + getWinPercentage().get(3) + "%\n");
        System.out.println("\t\t\tthe sum of games played is: " + getSumOfWins().get(1) + "\n");
        System.out.println("----------------------------------------------------");
        System.out.println("\n\t\t\tplayer VS computerMediumMode\n");
        System.out.println("\t\t\tuser number of wins is: " + getResults().get(4));
        System.out.println("\t\t\tpercent won: " + getWinPercentage().get(4) + "%\n");
        System.out.println("\t\t\tcomputer number of wins is: " + getResults().get(5));
        System.out.println("\t\t\tpercent won: " + getWinPercentage().get(5) + "%\n");
        System.out.println("\t\t\tthe sum of games played is: " + getSumOfWins().get(2) + "\n");
        System.out.println("----------------------------------------------------");
        System.out.println("\n\t   the total number of games played is: " + getSumOfWins().get(3) + "\n");
        System.out.println("----------------------------------------------------");

    }

    private static ArrayList<String> getWinPercentage() {

        float percentWinPVP1, percentWinPVP2, percentWinPVC1, percentWinPVC2, percentWinPVC3, percentWinPVC4;

        percentWinPVP1 = getPercentWins().get(0);
        percentWinPVP2 = getPercentWins().get(1);
        percentWinPVC1 = getPercentWins().get(2);
        percentWinPVC2 = getPercentWins().get(3);
        percentWinPVC3 = getPercentWins().get(4);
        percentWinPVC4 = getPercentWins().get(5);

        String winPercentage1 = String.format("%.02f", percentWinPVP1);
        String winPercentage2 = String.format("%.02f", percentWinPVP2);
        String winPercentage3 = String.format("%.02f", percentWinPVC1);
        String winPercentage4 = String.format("%.02f", percentWinPVC2);
        String winPercentage5 = String.format("%.02f", percentWinPVC3);
        String winPercentage6 = String.format("%.02f", percentWinPVC4);

        ArrayList<String> list = new ArrayList<>();
        list.add(winPercentage1);
        list.add(winPercentage2);
        list.add(winPercentage3);
        list.add(winPercentage4);
        list.add(winPercentage5);
        list.add(winPercentage6);

        return list;
    }

    private static ArrayList<Integer> getResults() {

        int resultPVP1, resultPVP2, resultPVC1, resultPVC2, resultPVC3, resultPVC4;

        HashMap<String, Result> testingMap = Counter.readHashMapWithObject();

        resultPVP1 = getPlayer1Wins("PVP", testingMap);
        resultPVP2 = getPlayer2Wins("PVP", testingMap);
        resultPVC1 = getPlayer1Wins("PVC1", testingMap);
        resultPVC2 = getPlayer2Wins("PVC1", testingMap);
        resultPVC3 = getPlayer1Wins("PVC2", testingMap);
        resultPVC4 = getPlayer2Wins("PVC2", testingMap);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(resultPVP1);
        list.add(resultPVP2);
        list.add(resultPVC1);
        list.add(resultPVC2);
        list.add(resultPVC3);
        list.add(resultPVC4);

        return list;
    }

    private static ArrayList<Integer> getSumOfWins() {

        int resultPVP1, resultPVP2, resultPVC1, resultPVC2, resultPVC3, resultPVC4;
        int sumOfWinsPVP, sumOfWinsPVC1, sumOfWinsPVC2, totalWins;

        resultPVP1 = getResults().get(0);
        resultPVP2 = getResults().get(1);
        resultPVC1 = getResults().get(2);
        resultPVC2 = getResults().get(3);
        resultPVC3 = getResults().get(4);
        resultPVC4 = getResults().get(5);

        sumOfWinsPVP = resultPVP1 + resultPVP2;
        sumOfWinsPVC1 = resultPVC1 + resultPVC2;
        sumOfWinsPVC2 = resultPVC3 + resultPVC4;
        totalWins = sumOfWinsPVP + sumOfWinsPVC1 + sumOfWinsPVC2;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(sumOfWinsPVP);
        list.add(sumOfWinsPVC1);
        list.add(sumOfWinsPVC2);
        list.add(totalWins);

        return list;
    }


    private static ArrayList<Float> getPercentWins() {

        float percentWinPVP1, percentWinPVP2, percentWinPVC1, percentWinPVC2, percentWinPVC3, percentWinPVC4;

        percentWinPVP1 = calculatePercentage(getResults().get(0), getSumOfWins().get(0));
        percentWinPVP2 = calculatePercentage(getResults().get(1), getSumOfWins().get(0));
        percentWinPVC1 = calculatePercentage(getResults().get(2), getSumOfWins().get(1));
        percentWinPVC2 = calculatePercentage(getResults().get(3), getSumOfWins().get(1));
        percentWinPVC3 = calculatePercentage(getResults().get(4), getSumOfWins().get(2));
        percentWinPVC4 = calculatePercentage(getResults().get(5), getSumOfWins().get(2));

        ArrayList<Float> list = new ArrayList<>();
        list.add(percentWinPVP1);
        list.add(percentWinPVP2);
        list.add(percentWinPVC1);
        list.add(percentWinPVC2);
        list.add(percentWinPVC3);
        list.add(percentWinPVC4);

        return list;
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

