package es.upm.miw.apaw.epc2.gabriel.munumel.api.controllers;

import java.util.Optional;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DaoFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.dtos.DriverDto;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Driver;

public class DriverController {

	private boolean existDriverId(int driverId) {
		return DaoFactory.getFactory().getDriverDao().read(driverId) != null;
	}

	public void createDriver(String driverReference) {
		DaoFactory.getFactory().getDriverDao().create(new Driver(driverReference));
	}

	public void createDriver(String driverReference, Long driverPhone) {
		DaoFactory.getFactory().getDriverDao().create(new Driver(driverReference, driverPhone));
	}
	
	public void updateDriver(String driverReference) {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}

	public void updateDriver(String driverReference, Long driverPhone) {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}

	public Optional<DriverDto> readDriver(int driverId) {
		if (existDriverId(driverId)) {
            return Optional.of(new DriverDto(DaoFactory.getFactory().getDriverDao().read(driverId)));
        } else {
            return Optional.empty();
        }
	}  
}
