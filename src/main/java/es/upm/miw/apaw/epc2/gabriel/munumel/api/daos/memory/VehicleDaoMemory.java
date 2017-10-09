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
		return -1;
	}

	@Override
	protected void setId(Vehicle entity, Integer id) {
	}
	
	@Override
	protected Long getIdLong(Vehicle entity) {
		return entity.getId();
	}

	@Override
	protected void setIdLong(Vehicle entity, Long id) {
		entity.setId(id);
	}

	@Override
	public List<Vehicle> findVehiclesByDriverId(int driverId) {
		List<Vehicle> vehicles = this.findAll();
		List<Vehicle> vehiclesValue = new ArrayList<>();
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getDriver().getId() == driverId) {
				vehiclesValue.add(vehicle);
			}
		}
		return vehiclesValue;
	}
}
