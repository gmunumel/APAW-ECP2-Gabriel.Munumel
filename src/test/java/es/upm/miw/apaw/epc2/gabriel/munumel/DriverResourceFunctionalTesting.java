package es.upm.miw.apaw.epc2.gabriel.munumel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.DaoFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.epc2.gabriel.munumel.api.resources.DriverResource;
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

    @Test
    public void testCreateDriver() { 
        this.createDriverReferencePhone();
    }
    
    @Test
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
    
    @Test
    public void testReadDriver() {
        this.testCreateDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(DriverResource.DRIVERS).path(DriverResource.ID)
                .expandPath("1").build();
        assertEquals("{\"id\":1,\"reference\":\"1234XYZ,\"phone\":\"666666666\"}", new HttpClientService().httpRequest(request).getBody());
    }
    
    @Test(expected = HttpException.class)
    public void testReadDriverNotInteger() {
        this.testCreateDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(DriverResource.DRIVERS).path(DriverResource.ID)
                .expandPath("AAA").build();
        new HttpClientService().httpRequest(request).getBody();
    }
    
    @Test(expected = HttpException.class)
    public void testReadDriverNotFound() {
        this.testCreateDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(DriverResource.DRIVERS).path(DriverResource.ID)
                .expandPath("999").build();
        new HttpClientService().httpRequest(request).getBody();
    }  
    
    @Test
    public void testUpdateDriver() {
        this.testCreateDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(DriverResource.DRIVERS).body("XYDH1234:777777777").path(DriverResource.ID)
                .expandPath("1").build();
        new HttpClientService().httpRequest(request).getBody();
    }
    
    @Test
    public void testUpdateDriverReference() {
        this.testCreateDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(DriverResource.DRIVERS).body("XYDH1234:").path(DriverResource.ID)
                .expandPath("1").build();
        new HttpClientService().httpRequest(request).getBody();
    }

    @Test(expected = HttpException.class)
    public void testUpdateDriverNotInteger() {
        this.testCreateDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(DriverResource.DRIVERS).body("XYDH1234:777777777").path(DriverResource.ID)
                .expandPath("AAA").build();
        new HttpClientService().httpRequest(request).getBody();
    }
    
    @Test(expected = HttpException.class)
    public void testUpdateDriverNotFound() {
        this.testCreateDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(DriverResource.DRIVERS).body("XYDH1234:777777777").path(DriverResource.ID)
                .expandPath("999").build();
        new HttpClientService().httpRequest(request).getBody();
    }  
}
