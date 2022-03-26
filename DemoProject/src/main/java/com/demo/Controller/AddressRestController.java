package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Model.Address;
import com.demo.Service.AddressService;


@RestController
@RequestMapping("/Address")
public class AddressRestController {
	
	@Autowired
	AddressService service;
	
	
	  @GetMapping("/fetchByCity/{city}")
	  
	  public ResponseEntity<List<Address>> fetchByCity(@PathVariable String city) {
	  System.out.println(city); 
	  List<Address> obj = service.FindStudentByCity(city); 
	  System.out.println(obj);
	  return new ResponseEntity <List<Address>>(obj, HttpStatus.OK); }
	 
	

}
