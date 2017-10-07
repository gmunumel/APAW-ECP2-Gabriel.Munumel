package es.upm.miw.apaw.epc2.gabriel.munumel.api.resources;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.exceptions.DriverFieldInvalidException;

public class DriverResource {

    public static final String DRIVERS = "drivers";

    public static final String ID = "/{id}";

    public void createDriver(String driverReference) throws DriverFieldInvalidException {
    		this.validateField(driverReference);
    }
    
    public void createDriver(String driverReference, String driverPhone) throws DriverFieldInvalidException {
    		this.validateField(driverReference);
    }
    
    private void validateField(String field) throws DriverFieldInvalidException {
        if (field == null || field.isEmpty() || field.split(":")[0].isEmpty()) { 
            throw new DriverFieldInvalidException(field);
        }
    }

}
