package ComplexDataStructures;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class DriversVehicles {
    public static String[] vehicles = { "ambulance", "helicopter", "lifeboat"};
    public static String[][] drivers= {
            {"Fred", "Sue", "Pete"},
            {"Sue", "Richard", "Bob", "Fred"},
            {"Pete", "Mary", "Bob"}
    };

    public static void main(String[] args) {
        Map<String, Set<String>> personnel = new HashMap<>(); // map vehicles with drivers

        for(int i = 0; i < vehicles.length; i++){
            String vehicle = vehicles[i];
            String[] driverList = drivers[i];

            Set<String> driverSet = new LinkedHashSet<>(); // arranges the driverSet items by its original order

            for (String driver: driverList) {
                driverSet.add(driver);
            }
            personnel.put(vehicle, driverSet);
        }
        System.out.println(personnel);

        // create a list of drivers that are qualified to operate the specified vehicle
        Set<String> drivers = personnel.get("lifeboat");

        for(String driver: drivers){
            System.out.println(driver); // shows drivers that are qualified for helicopter
        }


        // Iterate through the whole vehicle-driver list
        System.out.println("***Vehicle - Qualified drivers***");
        for(String vehicle: personnel.keySet()){
            System.out.print(vehicle);
            System.out.print(": ");
            Set<String> driverList = personnel.get(vehicle);

            for(String driver: driverList){
                System.out.print(driver);
                System.out.print(", ");
            }

            System.out.println();
        }
    }

}
