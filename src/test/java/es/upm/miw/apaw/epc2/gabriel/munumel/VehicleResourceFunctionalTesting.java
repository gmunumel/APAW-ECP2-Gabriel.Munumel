package es.upm.miw.apaw.epc2.gabriel.munumel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DaoFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.DriverResource;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.VehicleResource;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpClientService;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpException;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpMethod;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpRequest;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpRequestBuilder;

public class VehicleResourceFunctionalTesting {
	
    @Before
    public void before() { 
    		DaoFactory.setFactory(new DaoMemoryFactory());       
    }
    
    private void createDriver() {
    		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DriverResource.DRIVERS)
        		.body("1234XYZ:666666666").build();
        new HttpClientService().httpRequest(request);
    }

    private void createVehicleBrandModelDriverIdEnum() {
    		this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(VehicleResource.VEHICLES)
        		.body("BMW:T1000:1:GASOLINE").build();
        new HttpClientService().httpRequest(request);
    }
    
    private void createVehicles() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(VehicleResource.VEHICLES)
        		.body("BMW:T1000:1:GASOLINE").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(VehicleResource.VEHICLES)
        		.body("Mercedes:CLQ:1:DIESEL").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testCreateVehicles() {
        this.createVehicles();
    }

    @Test
    public void testCreateVehicle() { 
        this.createVehicleBrandModelDriverIdEnum();
    }

    @Test(expected = HttpException.class) 
    public void testCreateVehicleBrandEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(VehicleResource.VEHICLES)
        		.body(":T1000:1:GASOLINE").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateVehicleModelEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(VehicleResource.VEHICLES)
        		.body("BMW::1:GASOLINE").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test(expected = HttpException.class)
    public void testCreateVehicleDriverEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(VehicleResource.VEHICLES)
        		.body("BMW:T1000::GASOLINE").build();
        new HttpClientService().httpRequest(request);
    }  
    
    @Test(expected = HttpException.class)
    public void testCreateVehicleDriverIdNotFound() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(VehicleResource.VEHICLES)
        		.body("BMW:T1000:999:GASOLINE").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test(expected = HttpException.class)
    public void testCreateVehicleFuelEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(VehicleResource.VEHICLES)
        		.body("BMW:T1000:1:").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test(expected = HttpException.class)
    public void testCreateVehicleWithoutFields() { 
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(VehicleResource.VEHICLES)
        		.body("").build();
        new HttpClientService().httpRequest(request);
    } 
    
    @Test
    public void testVehicleList() {
        this.createVehicles();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(VehicleResource.VEHICLES).build();
        assertEquals("[{\"id\":1,\"brand\":\"BMW\",\"model\":\"T1000\",\"driver\":1,\"fuel\":\"GASOLINE\"}, "
        			   + "{\"id\":2,\"brand\":\"Mercedes\",\"model\":\"CLQ\",\"driver\":1,\"fuel\":\"DIESEL\"}]",
                new HttpClientService().httpRequest(request).getBody());
    }
}
