package es.upm.miw.apaw.epc2.gabriel.munumel.api.controllers;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DaoFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.memory.DaoMemoryFactory;

public class VehicleControllerIT {  

	private VehicleController vehicleController;

	@Before
	public void before() {
		DaoFactory.setFactory(new DaoMemoryFactory());
		vehicleController = new VehicleController();
	} 

	@Test
	public void testCreateVehicle() {
		assertTrue(true);
		// TODO
//		new DriverController().createDriver("1234XFG", 666666666L);
//		vehicleController.createVehicle("BMW", "T1000", 1, Fuel.GASOLINE);
//		assertEquals("BMW", vehicleController.getVehicle(1).get().getBrand());
//		assertEquals("T1000", vehicleController.getVehicle(1).get().getModel());
//		assertNotNull(vehicleController.getVehicle(1).get().getDriver());
//		assertEquals(Fuel.GASOLINE, vehicleController.getVehicle(1).get().getFuel());
	}
 
}
