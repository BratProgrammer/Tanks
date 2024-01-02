package Vehicles.Acstracts.CargoCar;

import Vehicles.ArmoredVehicles;

public abstract class CargoCar extends ArmoredVehicles {
    private int maxCargo = 0;
    private int numberOfSoldiers = 0;
    private int cargo;

    public CargoCar(int maxCargo ,int maxFuelLavel, int fuelСonsumptionOn100, String type) {
        super(maxFuelLavel, fuelСonsumptionOn100, type);
        this.maxCargo = maxCargo;
    }

    //TODO getCargo, getSoldiers, landTroops, landCargo
}
