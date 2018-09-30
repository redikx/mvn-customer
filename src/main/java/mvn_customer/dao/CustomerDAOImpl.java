package mvn_customer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mvn_customer.entities.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> thisQuery = session.createQuery("from Customer order by last_name", Customer.class);
		
		List<Customer> customers = thisQuery.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer addedCustomer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(addedCustomer);
		
	}

	@Override
	public Customer getCustomer(int id) {
	Session session = sessionFactory.getCurrentSession();
	Customer customer = session.get(Customer.class, id);
		return customer;	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
	Session session = sessionFactory.getCurrentSession();
	@SuppressWarnings("rawtypes")
	Query theQuery = session.createQuery("delete from Customer where id = :theCustomerId");
	theQuery.setParameter("theCustomerId", id);
	theQuery.executeUpdate();
		
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = null;
		
	if (theSearchName != null && theSearchName.trim().length() > 0 ) {
		theQuery = session.createQuery("from Customer where lower(firstName) like lower(:theName) or lower(lastName) like lower(:theName)",Customer.class);
		theQuery.setParameter("theName", "%" + theSearchName+ "%");
		
	}
		@SuppressWarnings("unchecked")
		List<Customer> customers = theQuery.getResultList();
		return customers;
	}

}
