package Tournament;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Tournament.Match.playAMatch;
import static Tournament.PlayersList.*;

public class Tournament implements Serializable {

    public static void main(String[] args) {

        String players16 = "tournament16Players";
        String players8 = "tournament8Players";
        String players4 = "tournament4Players";
        String players2 = "tournament2Players";
        String players1 = "tournamentWinner";
        String tournament = "tournamentMap.txt";
        int counter = 0;
        boolean check;

        if (readPlayersMapWithObject(tournament) == null) {

            selectingTournamentMode();
        }

        HashMap<String, ArrayList<String>> map = readPlayersMapWithObject(tournament);

        ArrayList<String> list16 = map.get(players16);
        ArrayList<String> list8 = map.get(players8);
        ArrayList<String> list4 = map.get(players4);
        ArrayList<String> list2 = map.get(players2);
        ArrayList<String> list1 = map.get(players1);

        System.out.println("1/16 - " + list16.size());
        System.out.println("1/8 - " + list8.size());
        System.out.println("1/4 - " + list4.size());
        System.out.println("1/2 - " + list2.size());
        System.out.println("winner - " + list1.size());

        if (list16.size() == 0 && list8.size() == 0 && list4.size() == 0 && list2.size() == 0 && list1.size() == 1) {

            selectingTournamentMode();
        }

        int choose = chooseNumberOfMatchesInARow();

        while (counter < choose) {

            if (list16.size() >= 2) {

                System.out.println("\nMATCH FOR ENTERING THE QUARTER FINALS!");

                check = playAMatch(list16.get(0), list16.get(1));

                if (check) {
                    System.out.println("\nthe winner is: " + list16.get(0));
                    addPlayer(map, players8, list16.get(0));
                } else {
                    System.out.println("\nthe winner is: " + list16.get(1));
                    addPlayer(map, players8, list16.get(1));
                }

                deletePlayer(map, players16, list16.get(1));
                deletePlayer(map, players16, list16.get(0));


            }

            if (list16.size() == 0 && list8.size() >= 2) {

                System.out.println("\nQUARTER FINALS!");

                check = playAMatch(list8.get(0), list8.get(1));

                if (check) {
                    System.out.println("\nthe winner is: " + list8.get(0));
                    addPlayer(map, players4, list8.get(0));
                } else {
                    System.out.println("\nthe winner is: " + list8.get(1));
                    addPlayer(map, players4, list8.get(1));
                }

                deletePlayer(map, players8, list8.get(1));
                deletePlayer(map, players8, list8.get(0));

            }

            if (list8.size() == 0 && list4.size() >= 2) {

                System.out.println("\nSEMI FINALS!");

                check = playAMatch(list4.get(0), list4.get(1));

                if (check) {
                    System.out.println("\nthe winner is: " + list4.get(0));
                    addPlayer(map, players2, list4.get(0));
                } else {
                    System.out.println("\nthe winner is: " + list4.get(1));
                    addPlayer(map, players2, list4.get(1));
                }

                deletePlayer(map, players4, list4.get(1));
                deletePlayer(map, players4, list4.get(0));

            }

            if (list4.size() == 0 && list2.size() >= 2) {

                System.out.println("\nFINAl!");

                check = playAMatch(list2.get(0), list2.get(1));

                if (check) {
                    System.out.println("\nIS THE WINNER OF THE TOURNAMENT IS: " + list2.get(0));
                    addPlayer(map, players1, list2.get(0));
                } else {
                    System.out.println("\nIS THE WINNER OF THE TOURNAMENT IS: " + list2.get(1));
                    addPlayer(map, players8, list2.get(0));
                }

                deletePlayer(map, players2, list2.get(1));
                deletePlayer(map, players2, list2.get(0));

                writePlayersList(map, tournament);


            }

            counter++;
        }
    }

    private static void addPlayer(HashMap<String, ArrayList<String>> map, String key, String player) {

        String tournament = "tournamentMap.txt";

        ArrayList<String> list = map.get(key);
        list.add(player);

        writePlayersList(map, tournament);

        try {

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tournament));
            out.writeObject(map);
            out.close();

        } catch (Exception e) {
            System.out.println("Exception - " + e);
        }
    }

    private static void deletePlayer(HashMap<String, ArrayList<String>> map, String key, String player) {

        String tournament = "tournamentMap.txt";

        ArrayList<String> list = map.get(key);
        list.remove(player);

        writePlayersList(map, tournament);

        try {

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tournament));
            out.writeObject(map);
            out.close();

        } catch (Exception e) {
            System.out.println("Exception - " + e);
        }
    }

    public static void writeTournamentHashMap() {

        String fileName = "tournamentMap.txt";

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        map.put("tournament16Players", new ArrayList<>());
        map.put("tournament8Players", new ArrayList<>());
        map.put("tournament4Players", new ArrayList<>());
        map.put("tournament2Players", new ArrayList<>());
        map.put("tournamentWinner", new ArrayList<>());

        writePlayersMapToObject(map, fileName);

    }

    private static void selectingTournamentMode() {

        Scanner scan = new Scanner(System.in);
        String modeName1 = "tournament16Players";
        String modeName2 = "tournament8Players";
        String modeName3 = "tournament4Players";
        String modeName4 = "tournament2Players";
        int choose = 0;

        System.out.println("\nWelcome to the tournament, select the tournament you want to create:");
        System.out.println("1 - 1/16");
        System.out.println("2 - quarter final");
        System.out.println("3 - semi-final");
        System.out.println("4 - final");

        try {
            choose = scan.nextInt();
            scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("\nException - " + e);
        }

        while (true) {

            if (choose == 1) {
                createPlayersList(modeName1, 16);
            } else if (choose == 2) {
                createPlayersList(modeName2, 8);
            } else if (choose == 3) {
                createPlayersList(modeName3, 4);
            } else if (choose == 4) {
                createPlayersList(modeName4, 2);
            } else {
                System.out.println("\nwrong number, try again");
                selectingTournamentMode();
            }

            break;
        }
    }

    private static int chooseNumberOfMatchesInARow() {

        Scanner scan = new Scanner(System.in);
        String players16 = "tournament16Players";
        String players8 = "tournament8Players";
        String players4 = "tournament4Players";
        String players2 = "tournament2Players";
        String tournament = "tournamentMap.txt";
        int choose = 10;
        int size;

        HashMap<String, ArrayList<String>> map = readPlayersMapWithObject(tournament);

        ArrayList<String> list16 = map.get(players16);
        ArrayList<String> list8 = map.get(players8);
        ArrayList<String> list4 = map.get(players4);
        ArrayList<String> list2 = map.get(players2);

        size = list16.size() + list8.size() + list4.size() + list2.size();
        size /= 2;

        System.out.println("\nhow many matches do you want to play in a row? - maximum " + size);

        try {
            choose = scan.nextInt();
            scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("\nException - " + e);
        }

        while (true) {

            if (choose <= size) {
                return choose;
            } else {
                System.out.println("\ntoo much, try again");
            }

            break;
        }

        return chooseNumberOfMatchesInARow();
    }

}

