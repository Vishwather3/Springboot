package com.example.ex.fav;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserFav{

	@Value("${color}")
	private String colour;
	
	@GetMapping("/Fav")
     public ResponseEntity<String> display()
     {
		String data = "My favourite colour is "+colour;
    	 return ResponseEntity.status(200).body(data);}
}