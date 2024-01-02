import Cannons.Armament;
import Vehicles.Acstracts.Btr_Bmp.*;
import Vehicles.Acstracts.Tanks.T90_M;
import Vehicles.Acstracts.Tanks.Tank;
import Vehicles.ArmoredVehicles;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<ArmoredVehicles> list = new ArrayList<ArmoredVehicles>();
        list.add(new Btr_80A());
        list.add(new Btr_80A());
        list.add(new Btr_80());
        list.add(new Btr_82A());
        list.add(new Btr_82A());
        list.add(new Btr_82A());
        list.add(new Btr_82A());
        list.add(new BMP_2());
        list.add(new BMP_2());
        list.add(new BMP_2());
        list.add(new BMP_2());
        list.add(new BMP_2());
        list.add(new T90_M());
        list.add(new T90_M());
        list.add(new T90_M());
        list.add(new T90_M());

        int sum =  list.stream()
                .mapToInt(x -> {
                    return x.getMaxFuelLavel();
                })
                .sum();

        ArrayList<ArmoredVehicles> someList = new ArrayList<>();

        someList = (ArrayList<ArmoredVehicles>) list.stream()
                        .sorted(new Comparator<ArmoredVehicles>() {
                            @Override
                            public int compare(ArmoredVehicles o1, ArmoredVehicles o2) {
                                double distance1 = (double) o1.getMaxFuelLavel() / o1.getFuelСonsumptionOn100();
                                double distance2 = (double) o2.getMaxFuelLavel() / o2.getFuelСonsumptionOn100();

                                return Double.compare(distance1, distance2);
                            }
                        }).collect(Collectors.toList());


       double averageMaxFuelLevel = list.stream()
                        .mapToInt(ArmoredVehicles::getMaxFuelLavel)
                        .average().getAsDouble();

       someList = (ArrayList<ArmoredVehicles>) list.stream()
               .filter(x -> { return "БТР-80А".equals(x.getType()); })
               .collect(Collectors.toList());

       HashSet<ArmoredVehicles> set = (HashSet<ArmoredVehicles>) list.stream()
               .filter(x -> { return x instanceof Btr; })
               .collect(Collectors.toSet());

       HashSet<String> armamentTypes = (HashSet<String>) list.stream()
                        .map(x -> {
                            if (x instanceof Btr) {
                                return ((Btr)x).getArmamentType();
                            } else {
                                return ((Tank)x).getArmamentType();
                            }
                        }).collect(Collectors.toSet());

       someList = (ArrayList<ArmoredVehicles>) list.stream()
                       .filter(x -> {
                           return !(x instanceof Btr) && ("2А46М5".equals(((Tank) x).getArmamentType()));
                       }).collect(Collectors.toList());


       for (ArmoredVehicles i : list) {
           if ((i instanceof Btr)) {
               ((Btr) i).reloadAmmunition();
           } else {
               ((Tank) i).reloadAmmunition();
           }
       }

        ((Btr)list.get(4)).asyncFire(10);
        ((Btr)list.get(4)).asyncFire(20);


        Thread.sleep(10000);

        for (ArmoredVehicles i : list) {
            if ((i instanceof Btr)) {
                System.out.println(((Btr) i).whoIs() + " Боекомплект основного орудия: " + ((Btr) i).getAmmunitionQuantity());
            } else {
                System.out.println(((Tank) i).whoIs() + " Боекомплект основного орудия: " + ((Tank) i).getAmmunitionQuantity());
            }
        }








        //System.out.println(someList);

    }

}