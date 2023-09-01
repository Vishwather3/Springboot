package com.day5_portal.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day5_portal.models.Book;
import com.day5_portal.repository.BookRepo;
import com.day5_portal.service.ApiService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ApiServiceImpl implements ApiService {
    @Autowired
	private BookRepo bookRepo;
    
    @Override
    public boolean adduser(Book book) {
    	boolean userExists = bookRepo.existsByBookName(book.getBookName());
		if(!userExists)
		{
			bookRepo.save(book);
			return true;
		}else {
			
			return false;
		}
    }

    
	@Override
	public boolean updateuser(Long id,Book book) {
		Optional<Book>existingUserOptional =bookRepo.findById(id);
		
		if(existingUserOptional.isPresent()) {
		Book userExists=existingUserOptional.get();
		userExists.setBookName(book.getBookName());
		userExists.setPrice(book.getPrice());
		userExists.setQuantity(book.getQuantity());
		userExists.setAuthorName(book.getAuthorName());;
		bookRepo.save(userExists);
		return true;
	}else {
		return false;
	}

}
	@Override
	public boolean deleteUser(Long id) {
		Optional<Book>existingUserOptional=bookRepo.findById(id);
		if(existingUserOptional.isPresent()) {
			bookRepo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}

	
}