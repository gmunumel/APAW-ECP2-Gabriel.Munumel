package es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.memory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DaoFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Driver;

public class DriverDaoMemoryTest {

    private Driver driver;

    @Before
    public void before() {  
        DaoFactory.setFactory(new DaoMemoryFactory());
        driver = new Driver("1234GHF", 666666666L);
        DaoFactory.getFactory().getDriverDao().create(driver);
    }

    @Test
    public void testCreateDriver() {
        assertEquals("1234GHF", DaoFactory.getFactory().getDriverDao().read(1).getReference());
        assertEquals(666666666L, DaoFactory.getFactory().getDriverDao().read(1).getPhone(), 0);
    }
    
    @Test
    public void testReadNonExistId() {
        assertNull(DaoFactory.getFactory().getDriverDao().read(2));
    }
    
    @Test
    public void testUpdateDriverReference() {  
    		DaoFactory.getFactory().getDriverDao().update(new Driver(1, "GHF1234"));
        assertEquals("GHF1234", DaoFactory.getFactory().getDriverDao().read(1).getReference());
        assertNull(DaoFactory.getFactory().getDriverDao().read(1).getPhone());
    } 

    @Test
    public void testUpdateDriverReferencePhone() {  
    		DaoFactory.getFactory().getDriverDao().update(new Driver(1, "GHF1234", 123456789L));
        assertEquals("GHF1234", DaoFactory.getFactory().getDriverDao().read(1).getReference());
        assertEquals(123456789L, DaoFactory.getFactory().getDriverDao().read(1).getPhone(), 0);
    } 
}
