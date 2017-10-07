package es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.exceptions;

public class DriverIdNotFoundException extends Exception {
    private static final long serialVersionUID = -3896470892899234744L;

    public static final String DESCRIPTION = "El id del conductor no existe";

    public DriverIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public DriverIdNotFoundException() {
        this("");
    }
}
