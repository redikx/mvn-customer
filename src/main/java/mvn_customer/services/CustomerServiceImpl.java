package mvn_customer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mvn_customer.dao.CustomerDAO;
import mvn_customer.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void addCustomer(Customer addedCustomer) {
		customerDAO.saveCustomer(addedCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
		
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		return customerDAO.searchCustomers(theSearchName);
	}

}
