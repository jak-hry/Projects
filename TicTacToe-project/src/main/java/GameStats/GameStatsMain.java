package GameStats;

import java.util.ArrayList;
import java.util.HashMap;

public class GameStatsMain {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        //licznik wygranych pierwszego gracza
        arrayList.add(1);
        //licznik wygranych drugiego gracza
        arrayList.add(2);

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        map.put("PVP", arrayList);
        map.put("PVC1", new ArrayList<>());
        map.put("PVC2", new ArrayList<>());

        addNumberSecondKey(map);
        addNumberThirdKey(map);
        incrementFirstCounter(map);
        incrementSecondCounter(map);

        ArrayList<Integer> firstValue = map.get("PVP");
        for (Integer element : firstValue) {
            System.out.println(element);
        }

        ArrayList<Integer> secondKey = map.get("PVC1");
        for (Integer element : secondKey) {
        //    System.out.println(element);
        }

        ArrayList<Integer> thirdKey = map.get("PVC2");
        for (Integer element : thirdKey) {
        //    System.out.println(element);
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

    public static void incrementFirstCounter(HashMap<String, ArrayList<Integer>> map) {

        ArrayList<Integer> list = map.get("PVP");
        int number = list.get(0);
        list.set(0, number + 1);
        map.put("PVP", list);

    }

    public static void incrementSecondCounter(HashMap<String, ArrayList<Integer>> map) {

        ArrayList<Integer> list = map.get("PVP");
        int number = list.get(1);
        list.set(1, number + 1);
        map.put("PVP", list);

    }
}
