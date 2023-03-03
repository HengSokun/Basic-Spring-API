package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class DemoApplication {

	static List<Customer> customers = new ArrayList<>();

	public DemoApplication(){
		customers.add(new Customer(12, "Heng", "M", "Phnom Penh"));
	}
	@PostMapping("/post/customer")
	public Customer createCustomer(String customerName,int customerAge, String customerGender, String customerAddress) {
		customers.add(new Customer(customerAge, customerName, customerGender, customerAddress));
		return (Customer) customers;
	}
//	public Customer createCustomer(@RequestBody Customer customer) {
//		customers.add(customer);
//		return customer;
//	}

	@GetMapping("/get/customer")
	public List<Customer> allCustomers(){
		return customers;
	}

	@GetMapping("/get/customer/{customerID}")
	public Customer getCustomerByID(@PathVariable(value = "customerID") int customerID){
		for (Customer cus: customers) {
			if (cus.customerID == customerID){
				return cus;
			}
		}
		return null;
	}

	@GetMapping("/get/customer/{customerName}")
	public Customer getCustomerByName(@RequestParam(value = "customerName") String customerName){
		for (Customer cus: customers) {
			if (Objects.equals(cus.customerName, customerName)){
				return cus;
			}
		}
		return null;
	}

	@PutMapping("/update/customer/{customerID}")
	public Customer updateCustomerByID(@PathVariable(value = "customerID") int customerID){
		for (Customer cus: customers) {
			if (cus.customerID == customerID){
				return cus;
			}
		}
		return null;
	}

	@DeleteMapping("/delete/customer/{customerID}")
	public Customer deleteCustomerByID(@PathVariable(value = "customerID") int customerID){
		for (Customer cus: customers) {
			if (cus.customerID == customerID){
				return cus;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}