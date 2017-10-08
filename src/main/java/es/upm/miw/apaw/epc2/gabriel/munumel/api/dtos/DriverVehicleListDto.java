package es.upm.miw.apaw.epc2.gabriel.munumel.api.dtos;

import java.util.List;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Driver;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Vehicle;

public class DriverVehicleListDto {

    private DriverDto driverDto;

    private List<Vehicle> vehicleList;

    public DriverVehicleListDto() { 
    }

    public DriverVehicleListDto(Driver driver, List<Vehicle> vehicleList) {
    		driverDto = new DriverDto(driver);
        this.vehicleList = vehicleList;
    }

    public DriverDto getDriverDto() { 
        return driverDto;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    @Override
    public String toString() {
        return "{" + driverDto + "," + vehicleList + "}";
    }

}
