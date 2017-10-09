package es.upm.miw.apaw.epc2.gabriel.munumel.api.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DaoFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Fuel;

public class VehicleControllerIT {  

	private VehicleController vehicleController;

	@Before
	public void before() {
		DaoFactory.setFactory(new DaoMemoryFactory());
		vehicleController = new VehicleController();
	} 

	@Test
	public void testCreateVehicle() {
		new DriverController().createDriver("1234XFG", 666666666L);
		vehicleController.createVehicle("BMW", "T1000", 1, Fuel.GASOLINE);
		assertEquals("BMW", vehicleController.vehicleList().get(0).getBrand());
		assertEquals("T1000", vehicleController.vehicleList().get(0).getModel());
		assertEquals(1, vehicleController.vehicleList().get(0).getDriverId());
		assertEquals(Fuel.GASOLINE, vehicleController.vehicleList().get(0).getFuel());
	}
 
	@Test
    public void testCreateVehicleAndVehicleList() {
        new DriverController().createDriver("1234XFG", 666666666L);
        vehicleController.createVehicle("BMW", "T1000", 1, Fuel.GASOLINE);
        vehicleController.createVehicle("Mercedes", "CLQ", 1, Fuel.DIESEL);
        assertEquals(2, vehicleController.vehicleList().size());
        assertEquals("BMW", vehicleController.vehicleList().get(0).getBrand());
        assertEquals("Mercedes", vehicleController.vehicleList().get(1).getBrand());
    }

    @Test
    public void testCreateVehicleNonExistentId() {
        new DriverController().createDriver("1234XFG", 666666666L);
        assertFalse(vehicleController.createVehicle("BMW", "T1000", 2, Fuel.GASOLINE));
    }
}
