package es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.memory;

import java.util.HashMap;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DriverDao;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Driver;

public class DriverDaoMemory extends GenericDaoMemory<Driver> implements DriverDao {

    public DriverDaoMemory() {  
        this.setMap(new HashMap<Integer, Driver>());
    }

    @Override
    protected Integer getId(Driver entity) {
        return entity.getId(); 
    }

    @Override
    protected void setId(Driver entity, Integer id) {
        entity.setId(id);  

    }

}
