package com.day5_portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.day5_portal.models.Book;
import com.day5_portal.service.ApiService;



@RestController
@RequestMapping("/api/v1/day5")
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
	@PostMapping("/addBook")
	public ResponseEntity<String>addUser(@RequestBody Book book){
		boolean dataSaved= apiService.adduser(book);
		if(dataSaved) {
			return ResponseEntity.status(200).body("Book data added successfully");
		}
		else {
			return ResponseEntity.status(404).body("Something went wrong");
		}
		
	}

	
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<String>updateuser(@PathVariable Long id,@RequestBody Book book){
	boolean userData=apiService.updateuser(id,book);
	if(userData) {
		return ResponseEntity.status(200).body("Book data updated successfully");
		
	}else {
		return ResponseEntity.status(404).body("No record");
	}

}
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<String>deleteUser(@PathVariable Long id){
		boolean userDeleted=apiService.deleteUser(id);
		if(userDeleted) {
			return ResponseEntity.status(200).body("Book data deleted successfully");
		}
		else {
			return ResponseEntity.status(404).body("No records");
		}
	}
}