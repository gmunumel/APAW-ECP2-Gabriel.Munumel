package es.upm.miw.apaw.epc2.gabriel.munumel;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.DriverResource;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.exceptions.RequestInvalidException;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpRequest;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpResponse;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpStatus;

public class Dispatcher {

	private DriverResource driverResource = new DriverResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet");
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
				response.setStatus(HttpStatus.CREATED);
			} else {
				throw new RequestInvalidException(request.getPath());
			}
		} catch (Exception e) {
			responseError(response, e);
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet");
	}

	public void doPatch(HttpRequest request, HttpResponse response) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet");
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet");
	}

}
