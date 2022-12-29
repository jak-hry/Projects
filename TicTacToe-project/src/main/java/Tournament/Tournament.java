package Tournament;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import static Tournament.Match.playAMatch;
import static Tournament.PlayersList.*;

public class Tournament implements Serializable {

    public static void main(String[] args) {

        String players16 = "16PlayersList";
        String players8 = "8PlayersList";
        String players4 = "4PlayersList";
        String players2 = "2PlayersList";
        boolean check;
        int counter = 0;

        HashMap<String, ArrayList<String>> tour16 = readPlayersMapWithObject(players16);
        assert tour16 != null;
        ArrayList<String> list16 = tour16.get(players16);

        HashMap<String, ArrayList<String>> tour8 = readPlayersMapWithObject(players8);
        assert tour8 != null;
        ArrayList<String> list8 = tour8.get(players8);

        HashMap<String, ArrayList<String>> tour4 = readPlayersMapWithObject(players4);
        assert tour4 != null;
        ArrayList<String> list4 = tour4.get(players4);

        HashMap<String, ArrayList<String>> tour2 = readPlayersMapWithObject(players2);
        assert tour2 != null;
        ArrayList<String> list2 = tour2.get(players2);

        System.out.println(list16.size());
        System.out.println(list8.size());
        System.out.println(list4.size());
        System.out.println(list2.size());

        if (list16.size() == 0 && list8.size() == 0 && list4.size() == 0 && list2.size() == 0) {
            createPlayersList();
        }

        if (list16.size() >= 2) {

            System.out.println("\nMECZ O WEJSCIE DO CWIERCFINALOW!");

            check = playAMatch(list16.get(0), list16.get(1));

            if (check) {
                System.out.println("\nthe winner is: " + list16.get(0));
                addPlayer(tour8, players8, list16.get(0));
            } else {
                System.out.println("\nthe winner is: " + list16.get(1));
                addPlayer(tour8, players8, list16.get(1));
            }


            deletePlayer(tour16, players16, list16.get(1));
            deletePlayer(tour16, players16, list16.get(0));

        }

        if (list16.size() == 0 && list8.size() >= 2) {

            System.out.println("\nCWIERCFINAL!\n");

            check = playAMatch(list8.get(0), list8.get(1));

            if (check) {
                System.out.println("\nthe winner is: " + list8.get(0));
                addPlayer(tour4, players4, list8.get(0));
            } else {
                System.out.println("\nthe winner is: " + list8.get(1));
                addPlayer(tour4, players4, list8.get(1));
            }

            deletePlayer(tour8, players8, list8.get(1));
            deletePlayer(tour8, players8, list8.get(0));


        }

        if (list8.size() == 0 && list4.size() >= 2) {

            System.out.println("\nPOLFINAL!\n");

            check = playAMatch(list4.get(0), list4.get(1));

            if (check) {
                System.out.println("\nthe winner is: " + list4.get(0));
                addPlayer(tour2, players2, list4.get(0));
            } else {
                System.out.println("\nthe winner is: " + list4.get(1));
                addPlayer(tour2, players2, list4.get(1));
            }

            deletePlayer(tour4, players4, list4.get(1));
            deletePlayer(tour4, players4, list4.get(0));

        }

        if (list4.size() == 0 && list2.size() >= 2) {

            System.out.println("FINAl!\n");

            check = playAMatch(list2.get(0), list2.get(1));

            if (check) {
                System.out.println("\nthe winner is: " + list2.get(0));
            } else {
                System.out.println("\nthe winner is: " + list2.get(1));
            }

            deletePlayer(tour2, players2, list2.get(1));
            deletePlayer(tour2, players2, list2.get(0));

        }

    }

    private static void addPlayer(HashMap<String, ArrayList<String>> map, String key, String player) {

        ArrayList<String> list = map.get(key);
        list.add(player);

        writePlayersList(key);

        try {

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(key));
            out.writeObject(map);
            out.close();

        } catch (Exception e) {
            System.out.println("Exception - " + e);
        }
    }

    private static void deletePlayer(HashMap<String, ArrayList<String>> map, String key, String player) {

        ArrayList<String> list = map.get(key);
        list.remove(player);

        writePlayersList(key);

        try {

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(key));
            out.writeObject(map);
            out.close();

        } catch (Exception e) {
            System.out.println("Exception - " + e);
        }
    }

}

