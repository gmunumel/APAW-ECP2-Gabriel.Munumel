package es.upm.miw.apaw.epc2.gabriel.munumel.api.resources;

import java.util.List;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.controllers.VehicleController;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.dtos.VehicleDto;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Fuel;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.exceptions.DriverIdNotFoundException;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.exceptions.VehicleFieldInvalidException;

public class VehicleResource {

	public static final String VEHICLES = "vehicles";

	public static final String ID = "/{id}";

	public void createVehicle(String vehicleBrand, String vehicleModel, int driverId, Fuel vehicleFuel) 
															throws VehicleFieldInvalidException, DriverIdNotFoundException {
		this.validateField(vehicleBrand, vehicleModel);
        if (!new VehicleController().createVehicle(vehicleBrand, vehicleModel, driverId, vehicleFuel)) {
        		throw new DriverIdNotFoundException(Integer.toString(driverId));
        }
	}
	
	public List<VehicleDto> vehicleList() {
		throw new java.lang.UnsupportedOperationException("Not implemented yet");
    }
	
	private void validateField(String vehicleBrand, String vehicleModel) throws VehicleFieldInvalidException {
        if (vehicleBrand == null || vehicleBrand.isEmpty()
    			|| vehicleModel == null || vehicleModel.isEmpty()) {
            throw new VehicleFieldInvalidException(vehicleBrand, vehicleModel);
        }
    }
}
