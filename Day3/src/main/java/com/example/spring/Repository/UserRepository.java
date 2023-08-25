package com.example.spring.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.day3.model.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Integer>{

	boolean existsByEmail(String email);
	Optional<User>findById(Long id);
	Optional<User> deleteById(Long id); 
	
	/*@Query("select u from User u")
	List<User>findAllQuery();
	
	@Query("select u from User u where u.email = :email")
	User findByEmail(@Param("email")String email);
	
	@Query("select u from User u where u.email=71")
	User findByEmailPlace(String email);*/
	
	//User updateUser(@Param("fName")String fname,@Param("id")Long id);
	
	@Modifying
	@Transactional
	@Query("update User u set u.firstName = :fName where u.id=:id")
	int updateUserQuery(@Param("fName") String fname,@Param("id") Long id);
	
	@Query(value="select * from user",nativeQuery=true)
	List<User>findAllQuery();
}

