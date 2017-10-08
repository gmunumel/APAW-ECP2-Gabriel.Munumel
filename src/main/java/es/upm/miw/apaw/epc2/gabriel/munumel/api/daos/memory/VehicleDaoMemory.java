package es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.VehicleDao;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Vehicle;

public class VehicleDaoMemory extends GenericDaoMemory<Vehicle> implements VehicleDao {

    public VehicleDaoMemory() {  
        this.setMap(new HashMap<Integer, Vehicle>());
    }

    @Override
    protected Integer getId(Vehicle entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Vehicle entity, Integer id) {
        entity.setId(id);
    }
    
    @Override
    public List<Integer> findValueByDriverId(int driverId) {
    		throw new java.lang.UnsupportedOperationException("Not implemented yet");
    }
}
