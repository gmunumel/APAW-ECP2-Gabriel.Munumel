package es.upm.miw.apaw.epc2.gabriel.munumel.api.resources;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.controllers.DriverController;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.exceptions.DriverFieldInvalidException;

public class DriverResource {

    public static final String DRIVERS = "drivers";

    public static final String ID = "/{id}";

    public String readDriver(int driverId) {
    		throw new java.lang.UnsupportedOperationException("Not implemented yet");
    }
    
    public void createDriver(String driverReference) throws DriverFieldInvalidException {
    		this.validateField(driverReference);
    		new DriverController().createDriver(driverReference);
    }
    
    public void createDriver(String driverReference, Long driverPhone) throws DriverFieldInvalidException {
    		this.validateField(driverReference);
    		new DriverController().createDriver(driverReference, driverPhone);
    }
    
    private void validateField(String field) throws DriverFieldInvalidException {
        if (field == null || field.isEmpty() || field.split(":")[0].isEmpty()) { 
            throw new DriverFieldInvalidException(field);
        }
    }

}
