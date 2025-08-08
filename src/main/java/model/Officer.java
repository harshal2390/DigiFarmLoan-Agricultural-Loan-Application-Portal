package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "officer")
@Component("officerModel")  // for model.Officer
public class Officer {
	@Id
	private int contact;
	private String name;
	private String bankName;
	private String email;
	private String password ;
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
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
	@Override
	public String toString() {
		return "Officer [contact=" + contact + ", name=" + name + ", bankName=" + bankName + ", email=" + email
				+ ", password=" + password + "]";
	}
	public Officer(int contact, String name, String bankName, String email, String password) {
		super();
		this.contact = contact;
		this.name = name;
		this.bankName = bankName;
		this.email = email;
		this.password = password;
	}
	public Officer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
