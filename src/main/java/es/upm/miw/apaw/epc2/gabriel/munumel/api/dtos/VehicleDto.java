package es.upm.miw.apaw.epc2.gabriel.munumel.api.dtos;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Fuel;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Vehicle;

public class VehicleDto {

    private int id;

    private String brand;
    
    private String model;
    
    private int driverId;
    
    private Fuel fuel;

    public VehicleDto() {
    }

    public VehicleDto(Vehicle vehicle) {
    		this.id = vehicle.getId();
    		this.brand = vehicle.getBrand();
    		this.model = vehicle.getModel();
        this.driverId = vehicle.getDriver().getId();
        this.fuel = vehicle.getFuel();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"brand\":\"" + brand + "\",\"model\":\"" + model +
        		   "\",\"driver\":" + driverId + ",\"fuel\":\"" + fuel +"\"}";
    }

}
