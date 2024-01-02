package Vehicles.Acstracts.Btr_Bmp;

import Cannons.Armament;
import Vehicles.ArmoredVehicles;

public abstract class Btr extends ArmoredVehicles {

    private int maxNumberOfSoldiers;
    private int numberOfSoldiers = 0;

    private static int numbers;
    private final int number;
    Armament cannon;

    public Btr(int maxFuelLavel, int fuelСonsumptionOn100, Armament cannon, int maxNumberOfSoldiers, String type) {
        super(maxFuelLavel, fuelСonsumptionOn100, type);
        this.cannon = cannon;
        this.maxNumberOfSoldiers = maxNumberOfSoldiers;
        numbers++;
        number = numbers;
    }

    public void getSoldiers(int numberOfSoldiers) {
        if (this.numberOfSoldiers + numberOfSoldiers > maxNumberOfSoldiers) {
            int remainder = numberOfSoldiers - (maxNumberOfSoldiers - this.numberOfSoldiers);
            this.numberOfSoldiers = maxNumberOfSoldiers;
            System.out.println(whoIs() + " Не хватило места для " + String.valueOf(remainder) + "солдат");
        } else {
            this.numberOfSoldiers += numberOfSoldiers;
        }
    }

    public void landTroops(int numberOfSoldiers) {
        this.numberOfSoldiers -= numberOfSoldiers;
    }

    public void landTroops() {
        numberOfSoldiers = 0;
        System.out.println(whoIs() + " Десант высажен");
    }

    public void reloadAmmunition(int numberOfAmmunition) {
        cannon.reloadAmmunition(numberOfAmmunition, whoIs());
    }

    public void reloadAmmunition() {
        cannon.reloadAmmunition(cannon.getMaxAmmunitionQuantity(), whoIs());
    }

    public void fire(int consumption) throws InterruptedException {
        cannon.fire(consumption, whoIs());
    }

    public void asyncFire(int consumption) {
        cannon.asyncFire(consumption, whoIs());
    }

    public int getAmmunitionQuantity() {
        return cannon.getAmmunitionQuantity();
    }

    public double getTempIsSecond() {
        return cannon.getTempIsSecond();
    }

    public String getArmamentType() {
        return cannon.getType();
    }
    public int getNumber() {
        return number;
    }

    public static int getNumberOfBtrs() {
        return numbers;
    }

    public String whoIs() {
        return this.getType() + " Бортовой номер " + this.getNumber();
    }
}

