package com.day5_portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.day5_portal.models.Book;


public interface BookRepo extends JpaRepository<Book,Integer>{

	Optional<Book>findById(Long id);
	Optional<Book>deleteById(Long id);
	boolean existsByBookName(String bookName);

}