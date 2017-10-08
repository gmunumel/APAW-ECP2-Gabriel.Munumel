package es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.memory;

import java.util.HashMap;

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
}
