package es.upm.miw.apaw.epc2.gabriel.munumel.api.resources;

import java.util.Optional;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.controllers.DriverController;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.controllers.VehicleController;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.dtos.DriverDto;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Fuel;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.exceptions.DriverFieldInvalidException;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.exceptions.DriverIdNotFoundException;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.exceptions.VehicleFieldInvalidException;

public class VehicleResource {

	public static final String VEHICLES = "vehicles";

	public static final String ID = "/{id}";

	public void createVehicle(String vehicleBrand, String vehicleModel, int driverId, Fuel vehicleFuel) 
																				throws VehicleFieldInvalidException {
		this.validateField(vehicleBrand, vehicleModel);
        new VehicleController().createVehicle(vehicleBrand, vehicleModel, driverId, vehicleFuel);
	}
	
	private void validateField(String vehicleBrand, String vehicleModel) throws VehicleFieldInvalidException {
        if (vehicleBrand == null || vehicleBrand.isEmpty()
    			|| vehicleModel == null || vehicleModel.isEmpty()) {
            throw new VehicleFieldInvalidException(vehicleBrand, vehicleModel);
        }
    }
}
