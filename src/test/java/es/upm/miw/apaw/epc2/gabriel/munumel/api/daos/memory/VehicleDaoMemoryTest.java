package es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.memory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DaoFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Driver;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Fuel;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Vehicle;

public class VehicleDaoMemoryTest {

	private Driver driver;
	
    private Vehicle vehicle;

    @Before
    public void before() {      
        DaoFactory.setFactory(new DaoMemoryFactory());
        driver = new Driver("1234FTG", 6666666666L);
        vehicle = new Vehicle("BMW", "T1000", driver, Fuel.GASOLINE);
        DaoFactory.getFactory().getVehicleDao().create(vehicle);
    }

    @Test
    public void testCreateVehicle() {
        assertEquals("BMW", DaoFactory.getFactory().getVehicleDao().get(1).getBrand());
        assertEquals("T1000", DaoFactory.getFactory().getVehicleDao().get(1).getModel());
        assertNotNull(DaoFactory.getFactory().getVehicleDao().get(1).getDriver());
        assertEquals(Fuel.GASOLINE, DaoFactory.getFactory().getVehicleDao().get(1).getFuel());
    } 
}
