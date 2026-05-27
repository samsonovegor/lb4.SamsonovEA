package lr9;

import java.util.*;

public class Example6 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "alpha");
        map.put(1, "beta");
        map.put(2, "gammaray");
        map.put(3, "delta");
        map.put(4, "epsilonn");
        map.put(5, "zeta");
        map.put(6, "etacarina");
        map.put(7, "theta");
        map.put(8, "iotabeam");
        map.put(9, "kappa");

        System.out.println("Исходный HashMap: " + map);
        System.out.println();

        System.out.println("1) Строки с ключом > 5:");
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            if (e.getKey() > 5) {
                System.out.println("   ключ=" + e.getKey() + " -> " + e.getValue());
            }
        }
        System.out.println();

        if (map.containsKey(0)) {
            String joined = String.join(", ", map.values());
            System.out.println("2) Ключ 0 присутствует. Все строки через запятую:");
            System.out.println("   " + joined);
        }
        System.out.println();

        long product = 1;
        boolean found = false;
        System.out.println("3) Ключи, у которых длина строки > 5:");
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            if (e.getValue().length() > 5) {
                System.out.println("   ключ=" + e.getKey() + " (\"" + e.getValue()
                        + "\", длина " + e.getValue().length() + ")");
                product *= e.getKey();
                found = true;
            }
        }
        System.out.println("   Произведение этих ключей = " + (found ? product : 0));
    }
}
