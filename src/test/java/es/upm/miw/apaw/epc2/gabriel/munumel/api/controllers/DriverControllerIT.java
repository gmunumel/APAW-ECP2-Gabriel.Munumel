package es.upm.miw.apaw.epc2.gabriel.munumel.api.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DaoFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.memory.DaoMemoryFactory;

public class DriverControllerIT {

	private DriverController driverController;

	@Before
	public void before() { 
		DaoFactory.setFactory(new DaoMemoryFactory());
		driverController = new DriverController();
		driverController.createDriver("2345HFJ", 777777777L);
	}

	@Test
	public void testCreateDriver() {
		assertEquals("2345HFJ", driverController.readDriver(1).get().getReference());
		assertEquals(777777777L, driverController.readDriver(1).get().getPhone(), 0);
	} 
	
	@Test
    public void testReadDriverNonExistId() {
       assertFalse(driverController.readDriver(2).isPresent());
    }

}
