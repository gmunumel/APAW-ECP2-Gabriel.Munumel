package es.upm.miw.apaw.epc2.gabriel.munumel.api.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class DriverTest {

    @Test
    public void testGetReference() {
        assertEquals("1234FGH", new Driver("1234FGH").getReference());
    }
    
    @Test
    public void testGetPhoneNull() {
        assertNull(new Driver("1234FGH").getPhone());
    }
    
    @Test
    public void testGetPhone() {
        assertEquals(1L, new Driver("1234FGH", 1L).getPhone(), 0);
    }

}
