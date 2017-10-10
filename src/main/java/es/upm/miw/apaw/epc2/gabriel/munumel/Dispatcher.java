package es.upm.miw.apaw.epc2.gabriel.munumel;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Fuel;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.DriverResource;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.VehicleResource;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.exceptions.RequestInvalidException;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpRequest;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpResponse;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpStatus;

public class Dispatcher {

	private DriverResource driverResource = new DriverResource();

	private VehicleResource vehicleResource = new VehicleResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) { 
		try {
			if (request.isEqualsPath(DriverResource.DRIVERS + DriverResource.ID)) {
				response.setBody(driverResource.getDriver(Integer.valueOf(request.paths()[1])).toString());
			} else if (request.isEqualsPath(DriverResource.DRIVERS + DriverResource.ID_VEHICLES)) {
				response.setBody(driverResource.getDriverVehicleList(Integer.valueOf(request.paths()[1])).toString());
			} else if (request.isEqualsPath(VehicleResource.VEHICLES)) {
				response.setBody(vehicleResource.vehicleList().toString()); 
			} else {
                throw new RequestInvalidException(request.getPath());
            }
		} catch (Exception e) {
			responseError(response, e);
		}  
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		try {
			if (request.isEqualsPath(DriverResource.DRIVERS)) {
				if (request.getBody().contains(":")) {
					String reference = request.getBody().split(":")[0]; // body="reference:phone"
					String phone = request.getBody().split(":")[1];
					driverResource.createDriver(reference, Long.parseLong(phone));
				} else
					driverResource.createDriver(request.getBody());
			} else if (request.isEqualsPath(VehicleResource.VEHICLES)) { // body="brand:model:driverId:fuel"
				String brand = splitBy(0, request.getBody());
				String model = splitBy(1, request.getBody());  
				String driverId = splitBy(2, request.getBody());
				String fuel = splitBy(3, request.getBody());
				vehicleResource.createVehicle(brand, model, Integer.parseInt(driverId), Fuel.valueOf(fuel));
			} else {
				throw new RequestInvalidException(request.getPath());
			}
			response.setStatus(HttpStatus.CREATED);
		} catch (Exception e) {
			responseError(response, e);
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet");
	}

	public void doPatch(HttpRequest request, HttpResponse response) {
		try {
			if (request.isEqualsPath(DriverResource.DRIVERS + DriverResource.ID)) {
				if (request.getBody().contains(":")) {
					String[] split = request.getBody().split(":");
					String reference = split[0]; // body="reference:phone"
					if (split.length == 2) {
						String phone = request.getBody().split(":")[1];
						driverResource.updateDriver(Integer.valueOf(request.paths()[1]), reference,
								Long.parseLong(phone));
					} else
						driverResource.updateDriver(Integer.valueOf(request.paths()[1]), reference);
				} else
					driverResource.updateDriver(Integer.valueOf(request.paths()[1]), request.getBody());
				response.setStatus(HttpStatus.CREATED);
			} else {
				throw new RequestInvalidException(request.getPath());
			}
		} catch (Exception e) {
			responseError(response, e);
		}
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet");
	}

	private String splitBy(int position, String string) {
		StringBuilder result = new StringBuilder();
		char[] chars = string.toCharArray();
		int countPos = -1;
		for (int i = 0; i < string.length(); i++) {
			if (chars[position] == ':' && position == 0)
				break;
			if (chars[i] == ':')
				countPos++;
			if (position == countPos)
				break;
			if (countPos == (position - 1) && chars[i] != ':')
				result.append(chars[i]);
		}
		return result.toString();
	}

}
