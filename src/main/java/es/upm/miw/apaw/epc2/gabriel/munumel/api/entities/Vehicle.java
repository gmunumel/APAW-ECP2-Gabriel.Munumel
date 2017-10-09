package es.upm.miw.apaw.epc2.gabriel.munumel.api.entities;

public class Vehicle {

	private Long id;

	private String brand;

	private String model;
	
	private Driver driver;
	
	private Fuel fuel;

	public Vehicle() {
	}
	
	public Vehicle(Long id) {
		this.id = id;
	}


	public Vehicle(Long id, String brand, String model, Driver driver, Fuel fuel) {
		this(id);
		this.brand = brand;
		this.model = model;
		this.driver = driver;
		this.fuel = fuel;
	}
	
	public Vehicle(String brand, String model, Driver driver, Fuel fuel) {
		this.brand = brand;
		this.model = model;
		this.driver = driver;
		this.fuel = fuel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}
	
	public Driver getDriver() {
		return driver;
	}
	
	public Fuel getFuel() {
		return fuel;
	}

	@Override
	public String toString() { 
		return "{\"id\":" + id + ",\"brand\":\"" + brand + "\",\"model\":\"" + model + "\",\"fuel\":\"" + fuel + "\"}";
	}

}
