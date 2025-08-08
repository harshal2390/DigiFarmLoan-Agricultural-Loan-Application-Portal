package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.FarmerDao;
import dao.LoanAppDao;
import model.Farmer;
import model.LoanAppications;
import model.Officer;

@Controller
public class FarmerControl {
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	FarmerDao farmerDao = (FarmerDao) context.getBean("farmerDao", FarmerDao.class);
	LoanAppDao loanAppDao =(LoanAppDao)context.getBean("loanAppDao",LoanAppDao.class);


	@RequestMapping(path = "/view_farmers")
	public String viewallfarms(Model m) {
		List<Farmer> allfarmer = farmerDao.viewAll();
		m.addAttribute("allfarmer", allfarmer);
		return "view_farmers";
	}

	@RequestMapping(path = "/FarmerLogin", method = RequestMethod.POST)
	public String AdminLogin(HttpServletRequest request) {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");

		Farmer farmer = farmerDao.getFarmerByEmailAndPassword(email, pass);

		if (farmer != null) {
			return "farmer_dashboard";
		} else {
			return "index";
		}
	}

	@RequestMapping(path = "/FarmerRegister", method = RequestMethod.POST)
	public String addFarmer(HttpServletRequest request) {
		Farmer farmer = new Farmer();
		farmer.setContact(Integer.parseInt(request.getParameter("contact")));
		farmer.setName(request.getParameter("name"));
		farmer.setLandSize(Double.parseDouble(request.getParameter("landSize"))); 
		farmer.setEmail(request.getParameter("email"));
		farmer.setPassword(request.getParameter("password"));

		int i = farmerDao.RegisterFarmer(farmer);
		if (i > 0) {
			return "farmer_dashbard";

		} else {
			return "FarmerRegister";
		}
	}
	@RequestMapping(path="/farmer_dashbard")
	public String farmerdash(){
		return "farmer_dashbard";
	}
	@RequestMapping(path="/farmerLoanApplcationView")
	public String openloanApp(Model m){
		
		 List<LoanAppications> allLoans = loanAppDao.viewAll();
		 m.addAttribute("allLoans", allLoans);
		return "farmerLoanApplcationView";
	}
	
	

}
