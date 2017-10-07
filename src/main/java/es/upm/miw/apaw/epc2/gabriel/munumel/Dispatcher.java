package es.upm.miw.apaw.epc2.gabriel.munumel;

import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpRequest;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpResponse;
import es.upm.miw.apaw.epc2.gabriel.munumel.http.HttpStatus;

public class Dispatcher {

//    private VoteResource voteResource = new VoteResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }
    
    public void doGet(HttpRequest request, HttpResponse response) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet");
    }

    public void doPost(HttpRequest request, HttpResponse response) {
    		throw new java.lang.UnsupportedOperationException("Not implemented yet");
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
