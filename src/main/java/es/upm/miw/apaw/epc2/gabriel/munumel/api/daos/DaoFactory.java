package es.upm.miw.apaw.epc2.gabriel.munumel.api.daos;

public abstract class DaoFactory {

    private static DaoFactory factory = null;

    public static void setFactory(DaoFactory factory) {
        DaoFactory.factory = factory;
    }

    public static DaoFactory getFactory() {
        assert factory != null;
        return factory;
    }

}
