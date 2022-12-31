package Tournament;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static Tournament.Tournament.writeTournamentHashMap;


public class PlayersList implements Serializable {

    public static void createPlayersList(String key, int size) {

        Scanner scan = new Scanner(System.in);

        String fileName = "tournamentMap.txt";
        ArrayList<String> playersList = new ArrayList<>();

        if (size == 16) {
            System.out.println("write a list of 16 people participating in the 1/16 tournament");
        } else if (size == 8) {
            System.out.println("write a list of 8 people participating in the quarter-finals");
        } else if ( size == 4) {
            System.out.println("write a list of 4 people participating in the semi-finals");
        } else if ( size == 2) {
            System.out.println("write a list of 2 people participating in the finals");
        }

        for (int i = 0; playersList.size() < size; i++) {

            String playerName = scan.nextLine();

            if (playersList.contains(playerName)) {
                System.out.println("\nNazwa gracza już istnieje, wybierz inną nazwę\n");
            } else {
                playersList.add(playerName);
            }
        }

        writeTournamentHashMap();
        HashMap<String, ArrayList<String>> map = readPlayersMapWithObject(fileName);
        map.put(key, playersList);

        writePlayersMapToObject(map, fileName);

    }

    public static void writePlayersList(HashMap<String, ArrayList<String>> playersList, String fileName) {

        playersList.put(fileName, new ArrayList<>());

        writePlayersMapToObject(playersList, fileName);

    }

    public static void writePlayersMapToObject(HashMap<String, ArrayList<String>> map, String fileName) {

        try {

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(map);
            out.close();

        } catch (Exception e) {
            System.out.println("Exception - " + e);
        }
    }

    public static HashMap<String, ArrayList<String>> readPlayersMapWithObject(String fileName) {

        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            HashMap<String, ArrayList<String>> readMap = (HashMap<String, ArrayList<String>>) ois.readObject();
            ois.close();
            return readMap;

        } catch (Exception e) {
            System.out.println("Exception - " + e);
            return null;
        }
    }

}
