package Vehicles.Acstracts.Tanks;

import Cannons.Armament;
import Cannons.Cannon2A46M5;
import Vehicles.Acstracts.Btr_Bmp.Btr;
import Vehicles.Acstracts.Vehicle;

public class T90_M extends Tank {
    public T90_M() {
        super(1200, 400, new Cannon2A46M5(), "Т-90М");
    }
}
