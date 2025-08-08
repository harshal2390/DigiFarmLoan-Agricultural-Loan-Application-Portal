package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "LoanAppications")
@Component
public class LoanAppications {
	@Id
	private int contact;
	private int farmerContactId;
	private int loanAmount;
	private String purpose;
	private String applicationDate;
	private String status;

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public int getFarmerContactId() {
		return farmerContactId;
	}

	public void setFarmerContactId(int farmerContactId) {
		this.farmerContactId = farmerContactId;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LoanAppications [contact=" + contact + ", farmerContactId=" + farmerContactId + ", loanAmount="
				+ loanAmount + ", purpose=" + purpose + ", applicationDate=" + applicationDate + ", status=" + status
				+ "]";
	}

	public LoanAppications(int contact, int farmerContactId, int loanAmount, String purpose, String applicationDate,
			String status) {
		super();
		this.contact = contact;
		this.farmerContactId = farmerContactId;
		this.loanAmount = loanAmount;
		this.purpose = purpose;
		this.applicationDate = applicationDate;
		this.status = status;
	}

	public LoanAppications() {
		super();
		// TODO Auto-generated constructor stub
	}

}
