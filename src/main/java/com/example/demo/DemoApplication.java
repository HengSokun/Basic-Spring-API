package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/customers")
public class DemoApplication {

	static List<Customer> customers = new ArrayList<>();
	static int countID = 4;
	public DemoApplication(){
		customers.add(new Customer(1, 25, "Heng", "M", "Phnom Penh"));
		customers.add(new Customer(2, 29, "Thong", "M", "Siem Reap"));
		customers.add(new Customer(2, 21, "Anos", "M", "Kompong Cham"));
	}

//	Insert customer method using PostMapping
	@PostMapping("/post/insert")
	public ResponseEntity<?> createCustomer(@RequestBody CustomerController customerController) {
		Customer customer = new Customer(countID++, customerController.getCustomerAge(), customerController.getCustomerName(), customerController.getCustomerGender(), customerController.getCustomerAddress());
		customers.add(customer);
		return new ResponseEntity<>(new CustomerDate(
				"This record was successfully created", customer,"OK",LocalDateTime.now()
		), HttpStatus.OK);
	}
//	public Customer createCustomer(String customerName,int customerAge, String customerGender, String customerAddress) {
//		customers.add(new Customer(customerAge, customerName, customerGender, customerAddress));
//		return (Customer) customers;
//	}


// Show all customer list from array
	@GetMapping("/get/showAll")
	public ResponseEntity<CustomerDate<List<Customer>>> allCustomers(){
		return ResponseEntity.ok(new CustomerDate<List<Customer>>(
				"You've got all customers successfully", customers,"OK",LocalDateTime.now()
		));
	}

//	Get customer by ID
	@GetMapping("/get/customerID={customerID}")
	@ResponseBody
	public ResponseEntity<?> getCustomerByID (@PathVariable(value = "customerID") int customerID){
		for (Customer cus: customers
		) {
			if(cus.getCustomerID() == customerID){
				return ResponseEntity.ok(new CustomerDate(
						"This record has found successfully", cus,"OK",LocalDateTime.now()
				));
			};
		} return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

//	Get customer by Name
	@GetMapping("/get/searchName")
	@ResponseBody
	public ResponseEntity<?> getCustomerByName(@RequestParam(value = "customerName") String customerName){
		for (Customer cus: customers
		) {
			if (Objects.equals(cus.customerName, customerName)){
				return new ResponseEntity<>(new CustomerDate(
						"This record has found successfully", cus,"OK",LocalDateTime.now()
				), HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

// Update customer by ID
	@PutMapping("/update/customerID={customerID}")
	public ResponseEntity<?> updateCustomerByID(@PathVariable(value = "customerID") int customerID, @RequestBody CustomerController customerController){
		for (Customer cus: customers
		) {
			if(cus.getCustomerID() == customerID){
				cus.setCustomerAge(customerController.getCustomerAge());
				cus.setCustomerName(customerController.getCustomerName());
				cus.setCustomerGender(customerController.getCustomerGender());
				cus.setCustomerAddress(customerController.getCustomerAddress());
				return new ResponseEntity<>(new CustomerDate(
						"You're update successfully", cus,"OK",LocalDateTime.now()
				), HttpStatus.OK);
			};
		} return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

//	Remove customer by ID
	@DeleteMapping("/delete/customerID={customerID}")
	public ResponseEntity<?> deleteCustomerByID(@PathVariable(value = "customerID") int customerID){
		for (Customer cus: customers
		) {
			if(cus.getCustomerID() == customerID){
				customers.remove(cus);
				return new ResponseEntity<>(new CustomerDate(
						"Congratulation your delete is successfully", cus,"OK",LocalDateTime.now()
				), HttpStatus.OK);
			};
		} return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}