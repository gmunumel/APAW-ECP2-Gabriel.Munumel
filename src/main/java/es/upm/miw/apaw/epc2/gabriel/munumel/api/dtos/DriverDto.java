package es.upm.miw.apaw.epc2.gabriel.munumel.api.dtos;

import es.upm.miw.apaw.epc2.gabriel.munumel.api.entities.Driver;

public class DriverDto {
    
    private int id;

    private String reference;
    
    private Long phone;

    public DriverDto() {
    }

    public DriverDto(Driver driver) {
        id = driver.getId();
        reference = driver.getReference();
        phone = driver.getPhone();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    
    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"reference\":\"" + reference + ",\"phone\":\"" + phone + "\"}";
    }

}
