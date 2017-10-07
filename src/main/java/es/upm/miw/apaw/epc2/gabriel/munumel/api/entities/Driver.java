package es.upm.miw.apaw.epc2.gabriel.munumel.api.entities;

public class Driver {

    private int id;

    private String reference;

    private Long phone;

    public Driver() {
    }
    
    public Driver(String reference) {
        this.reference = reference;
        this.phone = null;
    }

    public Driver(String reference, String phone) {
        this.reference = reference;
        this.phone = Long.parseLong(phone);
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

    public Long getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Theme [id=" + id + ", reference=" + reference + ", phone=" + phone + "]";
    }

}
