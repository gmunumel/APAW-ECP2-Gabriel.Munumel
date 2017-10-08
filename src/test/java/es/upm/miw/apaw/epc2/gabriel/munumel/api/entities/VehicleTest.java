package es.upm.miw.apaw.epc2.gabriel.munumel.api.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class VehicleTest {

    @Test
    public void testGetBrand() {
        assertEquals("BMW", new Vehicle("BMW", "T1000", new Driver("1234GTF", 6L), Fuel.GASOLINE).getBrand());
    }
    
    @Test
    public void testGetModel() {
    		assertEquals("T1000", new Vehicle("BMW", "T1000", new Driver("1234GTF", 6L), Fuel.GASOLINE).getModel());
    }
    
    @Test
    public void testGetDriver() {
        assertNotNull("T1000", new Vehicle("BMW", "T1000", new Driver("1234GTF", 6L), Fuel.GASOLINE).getDriver());
    }
    
    @Test
    public void testGetFuel() {
    		assertEquals(Fuel.GASOLINE, new Vehicle("BMW", "T1000", new Driver("1234GTF", 6L), Fuel.GASOLINE).getFuel());
    }
}
