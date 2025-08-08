package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.FarmerDao;
import dao.LoanAppDao;
import dao.OfficerDao;
import model.Farmer;
import model.LoanAppications;
import model.Officer;

@Controller
public class AdminControl {

	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	LoanAppDao loanAppDao = (LoanAppDao) context.getBean("loanAppDao", LoanAppDao.class);

	@RequestMapping("/")
	public String allLogin() {
		return "index";
	}

	@RequestMapping(path = "/AdminLogin", method = RequestMethod.POST)
	public String AdminLogin(HttpServletRequest request) {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");

		if (email.equals("admin@gmail.com") && pass.equals("admin")) {
			return "redirect:/view_farmers";
		} else {
			return "index";
		}

	}

	@RequestMapping(path = "/viewLoan")
	public String viewallLoans(Model m) {
		List<LoanAppications> allLoans = loanAppDao.viewAll();
		m.addAttribute("allLoans", allLoans);
		return "/viewLoan";
	}

	@RequestMapping(path = "/addofficer")
	public String openAddOfficer() {
		return "/addofficer";
	}

	@RequestMapping(path = "/applyforLoan")
	public String openapplyforloan() {
		return "/applyforLoan";
	}

	@RequestMapping(path = "/applyLoanfarmer", method = RequestMethod.POST)
	public String applyLoan(HttpServletRequest request) {
		LoanAppications loan = new LoanAppications();

		// Extracting form parameters and setting them into the object
		loan.setContact(Integer.parseInt(request.getParameter("laonid"))); 
		loan.setFarmerContactId(Integer.parseInt(request.getParameter("farmerContactId")));
		loan.setLoanAmount(Integer.parseInt(request.getParameter("loanAmount")));
		loan.setPurpose(request.getParameter("purpose"));
		loan.setApplicationDate(request.getParameter("applicationDate")); 
		loan.setStatus(request.getParameter("status"));

		int result = loanAppDao.insertLoanApplication(loan);

		if (result > 0) {
			return "farmer_dashboard"; 
		} else {
			return "loan_application_form"; 
		}
	}

	@RequestMapping("/officer_dashboard")
	public String showOfficerDashboard(Model model) {
		List<LoanAppications> loanList = loanAppDao.viewAll();
		model.addAttribute("loanList", loanList);
		return "officer_dashboard";
	}

	// Approve action
	@PostMapping("/approveLoan")
	public String approveLoan(@RequestParam("contact") int contact) {
		loanAppDao.updateStatus(contact, "Approved");
		return "redirect:/officer_dashboard";
	}

	// Reject action
	@PostMapping("/rejectLoan")
	public String rejectLoan(@RequestParam("contact") int contact) {
		loanAppDao.updateStatus(contact, "Rejected");
		return "redirect:/officer_dashboard";
	}
}
