package es.upm.miw.apaw.epc2.gabriel.munumel.api.daos;

import java.util.List;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Vehicle;

public interface VehicleDao extends GenericDao<Vehicle, Integer> {
	
	List<Integer> findValueByDriverId(int driverId);
	
}
