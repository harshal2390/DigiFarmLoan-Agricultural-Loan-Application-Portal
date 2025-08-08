package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import model.LoanAppications;
import model.Officer;

@Component
public class LoanAppDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public String toString() {
		return "LoanAppDao [hibernateTemplate=" + hibernateTemplate + "]";
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public LoanAppDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	
	public LoanAppDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public List<LoanAppications> viewAll() {
		return this.hibernateTemplate.loadAll(LoanAppications.class);
	}
	
	@Transactional
	public int insertLoanApplication(LoanAppications loan) {
		Integer i = (Integer) this.hibernateTemplate.save(loan);
		return i;

	}
	@Transactional
	 public void updateStatus(int contactId, String newStatus) {
	        LoanAppications loan = this.hibernateTemplate.get(LoanAppications.class, contactId);
	        if (loan != null) {
	            loan.setStatus(newStatus);
	            this.hibernateTemplate.update(loan);
	        }
	    }
	

}
