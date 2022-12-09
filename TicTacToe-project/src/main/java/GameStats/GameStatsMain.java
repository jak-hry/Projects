package GameStats;

import java.util.ArrayList;
import java.util.HashMap;

public class GameStatsMain {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        map.put("PVP", arrayList);
        map.put("PVC1", new ArrayList<>());
        map.put("PVC2", new ArrayList<>());

        addNumberSecondKey(map);
        addNumberThirdKey(map);
        increaseTheNumberBy1(map);

        ArrayList<Integer> firstKey = map.get("PVP");
        for (Integer element : firstKey) {
            System.out.println(element);
        }

        ArrayList<Integer> secondKey = map.get("PVC1");
        for (Integer element : secondKey) {
            System.out.println(element);
        }

        ArrayList<Integer> thirdKey = map.get("PVC2");
        for (Integer element : thirdKey) {
            System.out.println(element);
        }

        Object objectMap = map;
    }

    public static void addNumberSecondKey(HashMap<String, ArrayList<Integer>> map) {

        ArrayList<Integer> list = map.get("PVC1");
        list.add(3);
        int number = list.get(0);
        number++;
        list.set(0, number);
        map.put("PVC1", list);
    }

    public static void addNumberThirdKey(HashMap<String, ArrayList<Integer>> map) {

        ArrayList<Integer> list = map.get("PVC2");
        list.add(5);
    }

    public static void increaseTheNumberBy1(HashMap<String, ArrayList<Integer>> map) {

        ArrayList<Integer> list = map.get("PVP");
        int number = list.get(0);
        list.set(0, number + 1);
        map.put("PVP", list);

    }
}
