package es.upm.miw.apaw.epc2.gabriel.munumel;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DaoFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.DriverResource;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.exceptions.DriverFieldInvalidException;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpClientService;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpException;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpMethod;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpRequest;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpRequestBuilder;

public class DriverResourceFunctionalTesting {

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private void createDriverReferencePhone() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DriverResource.DRIVERS).body("1234XYZ:666666666").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateDriver() { 
        this.createDriverReferencePhone();
    }
    
    @Test(expected = HttpException.class)
    public void createDriverReference() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DriverResource.DRIVERS).body("1234XYZ").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateDriverReferenceEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DriverResource.DRIVERS).body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateWithoutDriverReference() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DriverResource.DRIVERS).build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test(expected = HttpException.class)
    public void testCreateDriverReferenceEmptyPhoneNotEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DriverResource.DRIVERS).body(":666666666").build();
        new HttpClientService().httpRequest(request);
    } 

}
