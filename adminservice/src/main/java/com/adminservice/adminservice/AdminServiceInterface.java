package com.adminservice.adminservice;

import com.adminservice.entity.Customer;

public interface AdminServiceInterface {

	int createProfile(Customer customer);

	Customer adminLoginService(Customer customer);

}
