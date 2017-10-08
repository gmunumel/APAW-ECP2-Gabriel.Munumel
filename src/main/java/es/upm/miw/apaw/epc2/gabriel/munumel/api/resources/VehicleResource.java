package es.upm.miw.apaw.epc2.gabriel.munumel.api.resources;

import java.util.Optional;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.controllers.DriverController;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.dtos.DriverDto;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Fuel;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.exceptions.DriverFieldInvalidException;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.exceptions.DriverIdNotFoundException;

public class VehicleResource {

	public static final String VEHICLES = "vehicles";

	public static final String ID = "/{id}";

	public void createVehicle(String vehicleBrand, String vehicleModel, int driverId, Fuel driverFuel) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet");
	}
}