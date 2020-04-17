package sql.demo;
import java.util.HashMap;
import java.util.Map;

public class ZModel {
    public static Map<String, Integer> GunMap = new HashMap<>();
    public static Map<String, Integer> BodyMap = new HashMap<>();
    public static Map<String, Integer> TowerMap = new HashMap<>();

    int GobalId=0;

    public ZModel() {
    }

    public void printMap() {
        System.out.println(GunMap);
    }

}
