package mvn_customer.services;

import java.util.List;

import mvn_customer.entities.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void addCustomer(Customer addedCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomers(String theSearchName);

}
