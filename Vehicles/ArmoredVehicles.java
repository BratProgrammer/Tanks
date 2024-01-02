package Vehicles;

import Vehicles.Acstracts.Vehicle;

import java.util.Objects;

public abstract class ArmoredVehicles implements Vehicle {
    private int fuelLavel = 0;
    private final int maxFuelLavel;
    private final int fuelСonsumptionOn100;

    private final String type;

    public ArmoredVehicles(int maxFuelLavel, int fuelСonsumptionOn100, String type) {
        this.fuelСonsumptionOn100 = fuelСonsumptionOn100;
        this.maxFuelLavel = maxFuelLavel;
        this.type = type;

    }

    public int getFuelLevel() {
        return fuelLavel;
    }

    public void refuel(int liters) {
        if (fuelLavel + liters > maxFuelLavel) {
            fuelLavel = maxFuelLavel;
        } else {
            fuelLavel += liters;
        }
        System.out.println("Топливо залито");
    }

    public void goToPoint(String point, int distance) throws InterruptedException {
        if (fuelLavel / fuelСonsumptionOn100 * 100 >= distance) {
            System.out.println("Выдвикаемся к " + point);
            Thread.sleep(1000);
            System.out.println("Доехал до " + point);
            fuelLavel -= (distance * fuelСonsumptionOn100) / 100;
        } else {
            System.out.println("Не хватит топлива");
        }
    }

    public int getMaxFuelLavel() {
        return maxFuelLavel;
    }

    public int getFuelСonsumptionOn100() {
        return fuelСonsumptionOn100;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(((ArmoredVehicles) obj).type, this.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return type;
    }
}
