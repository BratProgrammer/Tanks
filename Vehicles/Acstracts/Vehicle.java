package Vehicles.Acstracts;

import Vehicles.ArmoredVehicles;

public interface Vehicle {
    void goToPoint(String point, int distance) throws InterruptedException;
}
