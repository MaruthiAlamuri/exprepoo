package com.adminservice.adminrestcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adminservice.adminservice.AdminServiceInterface;
import com.adminservice.entity.Customer;

@RestController
public class AdminServicerRestController {
	
	@Autowired
	private AdminServiceInterface aservice;
	
	@PostMapping("AddCustomer")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
		       
        
		
		int addCustomer=aservice.createProfile(customer);
		String message="";
		
		if (addCustomer > 0) {
            message = "Customer registered successfully.";
            return ResponseEntity.ok(message);
        } else {
            message = "Customer registration failed.";
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
	
	}
	
	   @GetMapping("/login")
	    public ResponseEntity<String> loginAdmin(@RequestBody Customer customer) {
	        
	       Customer c = aservice.adminLoginService(customer);
	        
	        if (c != null) {
	            return ResponseEntity.ok("Login successful. Welcome, " + c);
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                                 .body("You have entered wrong credentials.");
	        }
	    }

}
