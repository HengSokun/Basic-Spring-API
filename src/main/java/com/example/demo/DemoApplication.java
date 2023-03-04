package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/customer")
public class DemoApplication {

	static List<Customer> customers = new ArrayList<>();
	static int countID = 3;
	public DemoApplication(){
		customers.add(new Customer(1, 25, "Heng", "M", "Phnom Penh"));
		customers.add(new Customer(2, 29, "He who remains", "M", "Siem Reap"));
	}

//	Insert customer method using PostMapping
	@PostMapping("/post")
	public Customer createCustomer(@RequestBody Customer customer) {
		customer.setCustomerID(countID++);
		customers.add(customer);
		return customer;
	}
//	public Customer createCustomer(String customerName,int customerAge, String customerGender, String customerAddress) {
//		customers.add(new Customer(customerAge, customerName, customerGender, customerAddress));
//		return (Customer) customers;
//	}


// Show all customer list from array
	@GetMapping("/get")
	public List<Customer> allCustomers(){
		return customers;
	}

//	Get customer by ID
	@GetMapping("/get/customerID={customerID}")
	@ResponseBody
	public ResponseEntity<Customer> getCustomerByID (@PathVariable(value = "customerID") int customerID){
		for (Customer cus: customers
		) {
			if(cus.getCustomerID() == customerID){
				return new ResponseEntity<>(cus, HttpStatus.OK);
			};
		} return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

//	Get customer by Name
	@GetMapping("/searchName")
	@ResponseBody
	public ResponseEntity<Customer> getCustomerByName(@RequestParam(value = "customerName") String customerName){
		for (Customer cus: customers
		) {
			if (Objects.equals(cus.customerName, customerName)){
				return new ResponseEntity<>(cus, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

// Update customer by ID
	@PutMapping("/update/customerID={customerID}")
	public ResponseEntity<Customer> updateCustomerByID(@PathVariable(value = "customerID") int customerID, @RequestBody Customer customer){
		for (Customer cus: customers
		) {
			if(cus.getCustomerID() == customerID){
				return new ResponseEntity<>(cus, HttpStatus.OK);
			};
		} return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/delete/customerID={customerID}")
	public ResponseEntity<Customer> deleteCustomerByID(@PathVariable(value = "customerID") int customerID){
		for (Customer cus: customers
		) {
			if(cus.getCustomerID() == customerID){
				customers.remove(customerID);
				return new ResponseEntity<>(cus, HttpStatus.OK);
			};
		} return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}