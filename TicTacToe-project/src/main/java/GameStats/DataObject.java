package GameStats;

import java.util.HashMap;
import java.util.Map;

public class DataObject {
    private HashMap<String, String> dataMap;

    // Konstruktor, który przyjmuje HashMapę jako argument
    public DataObject(HashMap<String, String> dataMap) {
        this.dataMap = dataMap;
    }

    // Metoda zwracająca zapisaną HashMapę
    public HashMap<String, String> getDataMap() {
        return dataMap;
    }
}

// Klasa odczytująca zapisaną wcześniej HashMapę
class DataReader {

    public static void main(String[] args) {

        DataReader dataReader = new DataReader();

        dataReader.readData();
    }

    public void readData() {
        // Tworzymy nową instancję obiektu DataObject
        DataObject dataObject = new DataObject(new HashMap<String, String>());

        // Pobieramy zapisaną HashMapę z obiektu
        HashMap<String, String> dataMap = dataObject.getDataMap();

        // Wyświetlamy zawartość HashMapy
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}




