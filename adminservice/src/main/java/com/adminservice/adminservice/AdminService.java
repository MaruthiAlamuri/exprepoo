package com.adminservice.adminservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminservice.adminservicedao.AdminServiceDaoInterface;
import com.adminservice.entity.Customer;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminService  implements AdminServiceInterface{

	@Autowired
	private AdminServiceDaoInterface adminServiceDao;

	
	@Override
	public int createProfile(Customer customer) {
	    try {
	        Customer savedCustomer = adminServiceDao.save(customer);
	        return (savedCustomer != null && savedCustomer.getId() != 0) ? 1 : 0;
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	        return 0; // Return failure
	    }
	}


	@Override
	public Customer adminLoginService(Customer customer) {
		// TODO Auto-generated method stub
		 return adminServiceDao.loginUser(customer.getEmail(), customer.getPassword());
	}
	
}
