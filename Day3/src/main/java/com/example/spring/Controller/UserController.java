package com.example.spring.Controller;


import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.Service.UserService;


@RestController
@RequestMapping("/api/v1/task")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUser")
	public ResponseEntity<List<User>>getUser(){
		return ResponseEntity.status(200).body(userService.getUser());
	}
	
	/*@GetMapping("/getQuery")
	public ResponseEntity<List<User>>findAllQuery(){
		return ResponseEntity.status(200).body(userService.findAllQuery());
	}*/
	

	@GetMapping("/getAllUser")
	public Page<User> getAllUser(
				@RequestParam(defaultValue = "0") int page, 
				@RequestParam(defaultValue = "5") int size,
				@RequestParam(defaultValue = "id") String sortField,
				@RequestParam(defaultValue = "asc") String sortOrder
			){
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortField));
		return userService.getAllUser(pageRequest);
	}
	
	@GetMapping("/fullName")
	public ResponseEntity<Object> getFullName(){
		return ResponseEntity.status(200).body(userService.getFullName());
	}
	
		
	@PostMapping("/addUser")
	public ResponseEntity<String>addUser(@RequestBody User user){
		boolean dataSaved= userService.addUser(user);
		if(dataSaved) {
			return ResponseEntity.status(200).body("User added successfully");
		}
		else {
			return ResponseEntity.status(404).body("Something went wrong");
		}
		
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<String>updateUser(@PathVariable Long id,@RequestBody User user){
		boolean userData=userService.updateUser(id,user);
		if(userData) {
			return ResponseEntity.status(200).body("User updated successfuly");
		}
		else {
			return ResponseEntity.status(404).body("No record found to be updated");
		}
	}
	
	@PutMapping("/updateUserQuery/{firstName}/{id}")
	public ResponseEntity<Integer>updateUserQuery(@PathVariable String firstName,@PathVariable Long id){
		return ResponseEntity.status(200).body(userService.updateUserQuery(firstName,id));
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String>deleteUser(@PathVariable Long id){
		boolean userDeleted=userService.deleteUser(id);
		if(userDeleted) {
			return ResponseEntity.status(200).body("User deleted successfuly");
		}
		else {
			return ResponseEntity.status(404).body("No record found to be updated");
		}
			
	}
	

}
