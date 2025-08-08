package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;



import model.Farmer;
import model.Officer;

@Component
public class FarmerDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public String toString() {
		return "FarmerDao [hibernateTemplate=" + hibernateTemplate + "]";
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public FarmerDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	public FarmerDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public List<Farmer> viewAll() {
		return this.hibernateTemplate.loadAll(Farmer.class);
	}
	
	public Farmer getFarmerByEmailAndPassword(String email, String password) {
	    List<Farmer> farmers = (List<Farmer>) hibernateTemplate.find("from Farmer where email = ?0 and password = ?1", email, password);
	    return farmers.isEmpty() ? null : farmers.get(0);
	}
	
	@Transactional
	public int RegisterFarmer(Farmer farmer) {
		Integer i = (Integer) this.hibernateTemplate.save(farmer);
		return i;

	}
	
	

	

}
