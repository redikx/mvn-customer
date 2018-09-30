package mvn_customer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mvn_customer.entities.Customer;
import mvn_customer.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired 
	private CustomerService customerService;
	
	@GetMapping("/list") 
	public String listCustomer(Model model) {
		
		List<Customer> listCustomers = customerService.getCustomers();
		model.addAttribute("listCustomers", listCustomers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		Customer theCustomer = customerService.getCustomer(id);
		model.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer addedCustomer) {
		customerService.addCustomer(addedCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
	
	@PostMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName") String theSearchName, Model model) {
		List<Customer> customers = customerService.searchCustomers(theSearchName);
		model.addAttribute("listCustomers", customers);
		
		return "list-customers";
	}

}
