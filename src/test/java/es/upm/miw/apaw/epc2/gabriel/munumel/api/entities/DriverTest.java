package es.upm.miw.apaw.epc2.gabriel.munumel.api.entities;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class DriverTest {

    @Test
    public void testGetReference() {
        assertNotNull(new Driver("1234FGH").getReference());
    }
    
    @Test
    public void testGetPhoneNull() {
        assertNull(new Driver("1234FGH").getPhone());
    }
    
    @Test
    public void testGetPhone() {
        assertNotNull(new Driver("1234FGH", 1L).getPhone());
    }

}
