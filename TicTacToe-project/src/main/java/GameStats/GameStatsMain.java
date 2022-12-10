package GameStats;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GameStatsMain implements Serializable {

    public static void main(String[] args) {

        Result result = new Result(0, 0);

        HashMap<String, Result> map = new HashMap<>();
        map.put("PVP", result);
        map.put("PVC1", result);
        map.put("PVC2", result);

        incrementFirstCounter(map);
        incrementSecondCounter(map);

        try {

            FileOutputStream fos = new FileOutputStream("map.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
            oos.close();

            FileInputStream fis = new FileInputStream("map.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            HashMap<String, Result> map2 = (HashMap<String, Result>)ois.readObject();
            ois.close();

            System.out.println(map2);

        } catch (Exception e) {
            System.out.println("Exception - " + e);
        }

    }

    public static void incrementFirstCounter(HashMap<String, Result> map) {

        map.get("PVP").incrementPlayer1();
    }

    public static void incrementSecondCounter(HashMap<String, Result> map) {

        map.get("PVC1").incrementPlayer2();
    }

}
