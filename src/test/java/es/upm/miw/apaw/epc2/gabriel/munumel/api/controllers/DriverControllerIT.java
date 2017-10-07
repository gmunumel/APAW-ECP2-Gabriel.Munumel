package es.upm.miw.apaw.epc2.gabriel.munumel.api.controllers;

import static org.junit.Assert.assertTrue;

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
		// TODO: not implemented yet
		assertTrue(true);
	}

	@Test
	public void testCreateDriverOnlyReference() {
		DriverController driverController = new DriverController();
		driverController.createDriver("2345HFJ");
		// TODO: not implemented yet
		assertTrue(true);
	}

}
