package com.ocp;

import com.ocp.vehicle.Car;
import com.ocp.vehicle.MotorCycle;

public class Main {
    private static TypeVehicle typeVehicle;
    public static void main(String[] args) {
	    typeVehicle = TypeVehicle.CAR;

	    if (typeVehicle == TypeVehicle.CAR)
        {
//            Vehicle vehicle = new Vehicle("Amaralo", "2021", 2.8, 4);
//            vehicle.car();
            Car car = new Car("Amaralo", "2021", 2.8, 4);
        }
	    else if (typeVehicle == TypeVehicle.MOTORCYCLE)
        {
//            Vehicle vehicle = new Vehicle("", "2022", 250,1);
//            vehicle.motorCycle();

            MotorCycle motorCycle = new MotorCycle("", "2022", 250.1);
        }
    }
}
