package com.day6.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.day6.model.Child;


public interface ChildRepo extends JpaRepository<Child,Integer>{

	Optional<Child>findByBabyId(Long babyId);
	Optional<Child>deleteByBabyId(Long babyId);
	boolean existsByAddress(String address);

}