package es.upm.miw.apaw.epc2.gabriel.munumel.api.controllers;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DaoFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Driver;

public class DriverController {

    public void createDriver(String driverReference) {
    		DaoFactory.getFactory().getDriverDao().create(new Driver(driverReference));
    }
    
    public void createDriver(String driverReference, String driverPhone) {
    		DaoFactory.getFactory().getDriverDao().create(new Driver(driverReference, driverPhone));
    }

}
