package Tournament;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class PlayersList implements Serializable {

    public static HashMap<String, ArrayList<String>> createPlayersList() {

        Scanner scan = new Scanner(System.in);
        String player1, player2, player3, player4,
                player5, player6, player7, player8,
                player9, player10, player11, player12,
                player13, player14, player15, player16;

        System.out.println("write a list of 16 people participating in the tournament");

        player1 = scan.nextLine();
        player2 = scan.nextLine();
        player3 = scan.nextLine();
        player4 = scan.nextLine();
        player5 = scan.nextLine();
        player6 = scan.nextLine();
        player7 = scan.nextLine();
        player8 = scan.nextLine();
        player9 = scan.nextLine();
        player10 = scan.nextLine();
        player11 = scan.nextLine();
        player12 = scan.nextLine();
        player13 = scan.nextLine();
        player14 = scan.nextLine();
        player15 = scan.nextLine();
        player16 = scan.nextLine();

        HashMap<String, ArrayList<String>> playersList = new HashMap<>();
        String fileName = "16PlayersList";

        playersList.put(fileName, new ArrayList<>(Arrays.asList(player1, player2, player3, player4,
                player5, player6, player7, player8,
                player9, player10, player11, player12,
                player13, player14, player15, player16)));


        writePlayersMapToObject(playersList, fileName);

        return playersList;
    }

    public static void writePlayersList(String fileName) {

        HashMap<String, ArrayList<String>> playersList = new HashMap<>();
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
