package com.day5_portal.service;

import com.day5_portal.models.Book;



public interface ApiService {
	

public boolean adduser(Book book);
public boolean updateuser(Long id, Book book);
boolean deleteUser(Long id);
}