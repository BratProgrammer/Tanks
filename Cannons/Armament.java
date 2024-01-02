package Cannons;

import java.util.Objects;

public abstract class Armament {
    private double caliber;
    private int distance;
    private int maxAmmunitionQuantity;
    private int ammunitionQuantity = 0;
    private double tempIsSecond = 0;
    private final String type;


    public Armament(double caliber, int distance, int maxAmmunitionQuantity, double tempInSecond, String type) {
        this.caliber = caliber;
        this.distance = distance;
        this.maxAmmunitionQuantity = maxAmmunitionQuantity;
        this.tempIsSecond = tempInSecond;
        this.type = type;
    }

    public boolean fire(int consumption, String whoIs) throws InterruptedException {
        for (int i = 0; i < consumption; i++) {
            if (ammunitionQuantity > 0) {
                ammunitionQuantity--;
                System.out.println(whoIs + " делает БАМ " + String.valueOf(i + 1));
                Thread.sleep((int) (1000 / tempIsSecond));
            } else {
                System.out.println(whoIs + " боеприпасов нет");
                return false;
            }
        }
        return true;
    }

    synchronized public void asyncFire(int consumption, String whoIs) {
        class FireThread extends Thread {
            @Override
            public void run() {
                try {
                    fire(consumption, whoIs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        new FireThread().start();
    }

    public int getAmmunitionQuantity() {
        return ammunitionQuantity;
    }

    public void reloadAmmunition(int numberOfAmmunition, String whoIs) {
        if (maxAmmunitionQuantity - ammunitionQuantity < numberOfAmmunition) {
            ammunitionQuantity = maxAmmunitionQuantity;
        } else {
            ammunitionQuantity += numberOfAmmunition;
        }
        System.out.println(whoIs + " Боекомплект пополнен");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Armament armament = (Armament) object;
        return Objects.equals(type, armament.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    public double getTempIsSecond() {
        return tempIsSecond;
    }

    public String getType() {
        return type;
    }

    public int getMaxAmmunitionQuantity() {
        return maxAmmunitionQuantity;
    }
}
