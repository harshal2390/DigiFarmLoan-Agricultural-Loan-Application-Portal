package model;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "farmer")
@Component
public class Farmer {
	@Id
	private int contact;
	private String name;
	private double landSize;
	private String email;
	private String password;
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public Farmer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Farmer(int contact, String name, double landSize, String email, String password) {
		super();
		this.contact = contact;
		this.name = name;
		this.landSize = landSize;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Farmer [contact=" + contact + ", name=" + name + ", landSize=" + landSize + ", email=" + email
				+ ", password=" + password + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLandSize() {
		return landSize;
	}
	public void setLandSize(double landSize) {
		this.landSize = landSize;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
