package es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.exceptions;

public class DriverFieldInvalidException extends Exception {
    private static final long serialVersionUID = -64201111876625537L;

    public static final String DESCRIPTION = "Referencia del conductor no encontrado";

    public DriverFieldInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public DriverFieldInvalidException() {
        this("");
    }

}
