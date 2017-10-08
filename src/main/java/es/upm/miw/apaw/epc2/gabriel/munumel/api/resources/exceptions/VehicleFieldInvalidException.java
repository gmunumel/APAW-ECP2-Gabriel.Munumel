package es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.exceptions;

public class VehicleFieldInvalidException extends Exception {
    private static final long serialVersionUID = -642011199996625537L;

    public static final String DESCRIPTION = "Marca o Modelo del vehículo vacío";

    public VehicleFieldInvalidException(String brand, String model) {
        super(DESCRIPTION + ". Brand = " + brand + " Model = " + model);
    }

    public VehicleFieldInvalidException() {
        this("", "");
    }

}
