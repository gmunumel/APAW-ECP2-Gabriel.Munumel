package es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.memory;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DaoFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DriverDao;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.VehicleDao;


public class DaoMemoryFactory extends DaoFactory {

	private DriverDao driverDao;
	
	private VehicleDao vehicleDao;

	@Override
    public DriverDao getDriverDao() {
		if (driverDao == null) {
			driverDao = new DriverDaoMemory();
        }
        return driverDao;
    }
	
	@Override
    public VehicleDao getVehicleDao() {
		if (vehicleDao == null) {
			vehicleDao = new VehicleDaoMemory();
        }
        return vehicleDao;
    }
}
