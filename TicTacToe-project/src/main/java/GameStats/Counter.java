package GameStats;

import java.io.*;
import java.util.HashMap;

public class Counter implements Serializable {

    public static void main(String[] args) {

        HashMap<String, Result> map = new HashMap<>();
        map.put("PVP", new Result());
        map.put("PVC1", new Result());
        map.put("PVC2", new Result());

        writeHashMapToObject(map);

    }

    public static void writeHashMapToObject(HashMap<String, Result> map) {

        try {

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("map.txt"));
            out.writeObject(map);
            out.close();

        } catch (Exception e) {
            System.out.println("Exception - " + e);
        }
    }

    public static HashMap<String, Result> readHashMapWithObject() {

        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("map.txt"));
            HashMap<String, Result> readMap = (HashMap<String, Result>) ois.readObject();
            ois.close();
            return readMap;

        } catch (Exception e) {
            System.out.println("Exception - " + e);
            return null;
        }
    }

    public static void incrementFirstCounter(HashMap<String, Result> map) {

        map.get("PVP").incrementPlayer1();
    }

    public static void incrementSecondCounter(HashMap<String, Result> map) {

        map.get("PVP").incrementPlayer2();
    }

    public static void incrementThirdCounter(HashMap<String, Result> map) {

        map.get("PVC1").incrementPlayer1();
    }

    public static void incrementFourthCounter(HashMap<String, Result> map) {

        map.get("PVC1").incrementPlayer2();
    }

    public static void incrementFifthCounter(HashMap<String, Result> map) {

        map.get("PVC2").incrementPlayer1();
    }

    public static void incrementSixthCounter(HashMap<String, Result> map) {

        map.get("PVC2").incrementPlayer2();
    }

}
