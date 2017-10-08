package es.upm.miw.apaw.epc2.gabriel.munumel.api.controllers;

import java.util.List;
import java.util.Optional;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DaoFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.dtos.DriverDto;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.dtos.DriverVehicleListDto;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Driver;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Vehicle;

public class DriverController {

	private boolean existDriverId(int driverId) {
		return DaoFactory.getFactory().getDriverDao().get(driverId) != null;
	}

	public void createDriver(String driverReference) {
		DaoFactory.getFactory().getDriverDao().create(new Driver(driverReference));
	}

	public void createDriver(String driverReference, Long driverPhone) {
		DaoFactory.getFactory().getDriverDao().create(new Driver(driverReference, driverPhone));
	}
	
	public void updateDriver(int driverId, String driverReference) {
		DaoFactory.getFactory().getDriverDao().update(new Driver(driverId, driverReference));
	}

	public void updateDriver(int driverId, String driverReference, Long driverPhone) {
		DaoFactory.getFactory().getDriverDao().update(new Driver(driverId, driverReference, driverPhone));
	}
	
	public Optional<DriverVehicleListDto> driverVehicles(int driverId) {
		if (existDriverId(driverId)) {
            List<Vehicle> vehicleList = DaoFactory.getFactory().getVehicleDao().findVehiclesByDriverId(driverId);
            return Optional.of(new DriverVehicleListDto(DaoFactory.getFactory().getDriverDao().get(driverId), vehicleList));
        } else {
            return Optional.empty();
        }
	}

	public Optional<DriverDto> getDriver(int driverId) {
		if (existDriverId(driverId)) {
            return Optional.of(new DriverDto(DaoFactory.getFactory().getDriverDao().get(driverId)));
        } else {
            return Optional.empty();
        }
	}  
}
