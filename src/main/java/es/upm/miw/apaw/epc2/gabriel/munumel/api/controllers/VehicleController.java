package es.upm.miw.apaw.epc2.gabriel.munumel.api.controllers;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DaoFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Driver;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Fuel;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Vehicle;

public class VehicleController {

	public boolean createVehicle(String vehicleBrand, String vehicleModel, int driverId, Fuel vehicleFuel) {
		Driver driver = DaoFactory.getFactory().getDriverDao().get(driverId);
		if (driver != null) {
            DaoFactory.getFactory().getVehicleDao().create(new Vehicle(vehicleBrand, vehicleModel, driver, vehicleFuel));
            return true;
        } else {
            return false;
        }
	}

}
