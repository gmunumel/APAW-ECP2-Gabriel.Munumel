package es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.memory;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DaoFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DriverDao;


public class DaoMemoryFactory extends DaoFactory {

	private DriverDao driverDao;

	@Override
    public DriverDao getDriverDao() {
		if (driverDao == null) {
			driverDao = new DriverDaoMemory();
        }
        return driverDao;
    }
}
