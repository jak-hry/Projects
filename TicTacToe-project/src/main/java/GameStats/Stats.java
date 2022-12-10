package GameStats;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class Stats {

    public static void main(String[] args) {

        try {

            FileInputStream fis = new FileInputStream("map.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            HashMap<String, Result> map2 = (HashMap<String, Result>)ois.readObject();
            ois.close();

            System.out.println(map2);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
