package es.upm.miw.apaw.epc2.gabriel.munumel.api.daos;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DriverDao;

public abstract class DaoFactory { 

    private static DaoFactory factory = null;

    public static void setFactory(DaoFactory factory) {
        DaoFactory.factory = factory;
    }

    public static DaoFactory getFactory() {
        assert factory != null;
        return factory;
    }
    
    public abstract DriverDao getDriverDao();

}
