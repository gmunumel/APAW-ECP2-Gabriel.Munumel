package es.upm.miw.apaw.epc2.gabriel.munumel.api.resources;

import java.util.Optional;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.controllers.DriverController;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.dtos.DriverDto;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.exceptions.DriverFieldInvalidException;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.exceptions.DriverIdNotFoundException;

public class DriverResource {

	public static final String DRIVERS = "drivers";

	public static final String ID = "/{id}";

	public DriverDto getDriver(int driverId) throws DriverIdNotFoundException {
		Optional<DriverDto> optional = new DriverController().getDriver(driverId);
		return optional.orElseThrow(() -> new DriverIdNotFoundException(Integer.toString(driverId)));
	}

	public void createDriver(String driverReference) throws DriverFieldInvalidException {
		this.validateField(driverReference);
		new DriverController().createDriver(driverReference);
	}

	public void createDriver(String driverReference, Long driverPhone) throws DriverFieldInvalidException {  
		this.validateField(driverReference);
		new DriverController().createDriver(driverReference, driverPhone);
	}

	public void updateDriver(int driverId, String driverReference) throws DriverIdNotFoundException, DriverFieldInvalidException {
		this.getDriver(driverId);
		this.validateField(driverReference);
		new DriverController().updateDriver(driverId, driverReference);
	}

	public void updateDriver(int driverId, String driverReference, Long driverPhone) throws DriverIdNotFoundException, DriverFieldInvalidException {
		this.getDriver(driverId);  
		this.validateField(driverReference);
		new DriverController().updateDriver(driverId, driverReference, driverPhone);
	}

	private void validateField(String field) throws DriverFieldInvalidException {
		if (field == null || field.isEmpty() || field.split(":")[0].isEmpty()) {
			throw new DriverFieldInvalidException(field);
		}
	}

}
