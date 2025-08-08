package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Farmer;
import model.Officer;




@Component
public class OfficerDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public OfficerDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OfficerDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public String toString() {
		return "OfficerDao [hibernateTemplate=" + hibernateTemplate + "]";
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public List<Officer> viewAll() {
		return this.hibernateTemplate.loadAll(Officer.class);
	}
	
	@Transactional
	public int insertOfficer(Officer officer) {
		Integer i = (Integer) this.hibernateTemplate.save(officer);
		return i;

	}
	@Transactional
	public void deleteOfficer(int id) {
	    Officer officer = this.hibernateTemplate.get(Officer.class, id);
	    if (officer != null) {
	        this.hibernateTemplate.delete(officer);
	    }
	}
	@Transactional
	public Officer getOfficerByEmailAndPassword(String email, String password) {
	    List<Officer> officers = (List<Officer>) hibernateTemplate.find("from Officer where email = ?0 and password = ?1", email, password);
	    return officers.isEmpty() ? null : officers.get(0);
	}

}
	
	

	
	
	


