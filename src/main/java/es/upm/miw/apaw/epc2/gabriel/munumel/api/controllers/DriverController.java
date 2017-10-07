package es.upm.miw.apaw.epc2.gabriel.munumel.api.controllers;

import java.util.Optional;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DaoFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.dtos.DriverDto;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Driver;

public class DriverController {

    public void createDriver(String driverReference) {
    		DaoFactory.getFactory().getDriverDao().create(new Driver(driverReference));
    }
    
    public void createDriver(String driverReference, Long driverPhone) {
    		DaoFactory.getFactory().getDriverDao().create(new Driver(driverReference, driverPhone));
    }
    
    public Optional <DriverDto> readDriver(int driverId) {
    		throw new java.lang.UnsupportedOperationException("Not implemented yet");
     }
}
