package es.upm.miw.apaw.epc2.gabriel.munumel.api.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DaoFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Fuel;

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
		assertEquals("2345HFJ", driverController.getDriver(1).get().getReference());
		assertEquals(777777777L, driverController.getDriver(1).get().getPhone(), 0);
	}

	@Test
	public void testGetDriverNonExistId() {
		assertFalse(driverController.getDriver(2).isPresent());
	}

	@Test
    public void testUpdateDriverReference() {
		driverController.updateDriver(1, "FGHJ4567");
		assertEquals("FGHJ4567", driverController.getDriver(1).get().getReference());
		assertNull(driverController.getDriver(1).get().getPhone());
    }
	
	@Test
    public void testUpdateDriverReferencePhone() {
		driverController.updateDriver(1, "FGHJ4567", 123456789L);
		assertEquals("FGHJ4567", driverController.getDriver(1).get().getReference());
		assertEquals(123456789L, driverController.getDriver(1).get().getPhone(), 0);
    } 
	
	@Test
    public void testGetDriverVehicle() {
        new VehicleController().createVehicle("BMW", "T1000", 1, Fuel.GASOLINE);
        new VehicleController().createVehicle("Mercedes", "CLQ", 1, Fuel.DIESEL);
        assertEquals("2345HFJ", driverController.driverVehicles(1).get().getDriverDto().getReference());
        assertEquals(777777777L, driverController.driverVehicles(1).get().getDriverDto().getPhone(), 0); 
        assertEquals("BMW", driverController.driverVehicles(1).get().getVehicleList().get(0).getBrand());
        assertEquals("T1000", driverController.driverVehicles(1).get().getVehicleList().get(0).getModel());
        assertEquals("Mercedes", driverController.driverVehicles(1).get().getVehicleList().get(1).getBrand());
        assertEquals("CLQ", driverController.driverVehicles(1).get().getVehicleList().get(1).getModel());
    }
 
}
