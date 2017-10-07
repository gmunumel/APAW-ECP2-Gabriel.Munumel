package es.upm.miw.apaw.epc2.gabriel.munumel.api.entities;

public class Driver {

	private int id;

	private String reference;

	private Long phone;

	public Driver() {
	}

	public Driver(int id) {
		this.id = id;
		this.reference = "";
		this.phone = null;
	}
	
	public Driver(String reference) {
		this.reference = reference;
		this.phone = null;
	}

	public Driver(int id, String reference) {
		this(id);
		this.reference = reference;
		this.phone = null;
	}

	public Driver(String reference, Long phone) {
		this(reference);
		this.phone = phone;
	}

	public Driver(int id, String reference, Long phone) {
		this(id);
		this.reference = reference;
		this.phone = phone;
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
