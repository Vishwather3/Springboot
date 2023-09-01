package com.example.spring.day2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class day2 {
   @Value("${val}")
   public String username;
   @GetMapping("/disp")
   public String display() {
	   return username;}
}
