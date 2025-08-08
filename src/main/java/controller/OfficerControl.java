package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.OfficerDao;
import model.Officer;

@Controller
public class OfficerControl {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	OfficerDao officerDao =(OfficerDao)context.getBean("officerDao",OfficerDao.class);
	   
	
	

    @RequestMapping(path = "/view_officers")
    public String viewallofficer(Model m) {
       List<Officer> allofficer = officerDao.viewAll();
      m.addAttribute("allofficer", allofficer);
        return "/view_officers";
   }

    @RequestMapping(path="/addofficer", method=RequestMethod.POST)
    public String addAnOfficer(HttpServletRequest request){
    	 Officer officer = new Officer();
    	officer.setContact(Integer.parseInt(request.getParameter("contact")));
    	officer.setName(request.getParameter("name"));
    	officer.setBankName(request.getParameter("bankName"));
    	officer.setEmail(request.getParameter("email"));
    	officer.setPassword(request.getParameter("password"));
    	int i=officerDao.insertOfficer(officer);
    	if(i>0){
    		return "redirect:/view_officers";
    	}else{
    		return "addofficer";
    	}
    	
    }
    @RequestMapping(path="/deleteofficer", method=RequestMethod.GET)
    public String deleteACC(HttpServletRequest request){
    	
    	int id=Integer.parseInt(request.getParameter("contact"));
    	officerDao.deleteOfficer(id);
		return "redirect:/view_officers";
    	
    }
    
    @RequestMapping(path = "/OfficerLogin", method = RequestMethod.POST)
    public String openOfficerLogin(HttpServletRequest request) {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        Officer officer = officerDao.getOfficerByEmailAndPassword(email, pass);

        if (officer != null) {
            return "redirect:/officer_dashboard";
        } else {
            return "index";
        }
    }
   

}
  
