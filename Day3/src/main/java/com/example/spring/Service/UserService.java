package com.example.spring.Service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.day3.model.User;
import com.example.day3.respository.UserRepository;
import com.example.day3.service.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		boolean userExists=userRepository.existsByEmail(user.getEmail());
		if(!userExists) {
			userRepository.save(user);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<User> getUser() {
		return userRepository.findAll();
	}

	@Override
	public boolean updateUser(Long id,User user) {
		//userRepository.saveAndFlush(user);
		Optional<User>existingUserOptional=userRepository.findById(id);
		
		if(existingUserOptional.isPresent()) {
			User userExists=existingUserOptional.get();
			userExists.setFirstName(user.getFirstName());
			userExists.setLastName(user.getLastName());
			userExists.setEmail(user.getEmail());
			userExists.setPassword(user.getPassword());
			userRepository.save(userExists);
			return true;
		}
		else {
			return false;
		}	
	}
	@Override
	public boolean deleteUser(Long id) {
		Optional<User>existingUserOptional=userRepository.findById(id);
		if(existingUserOptional.isPresent()) {
			userRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Page<User> getAllUser(PageRequest pageRequest) {
		
		return userRepository.findAll(pageRequest);
	}

	@Override
	public String getFullName() {
		User user = new User();
		var userL = userRepository.findAll();
		String fName = userL.get(1).getFirstName();
		String lName = userL.get(1).getLastName();
		return user.getFullName(fName, lName);
	}

	/*@Override
	public List<User> findAllQuery() {
		// TODO Auto-generated method stub
		return userRepository.findAllQuery();
	}

	@Override
	public User getEmail(String email) {
		return userRepository.findByEmail(email);
	}*/

	@Override
	public int updateUserQuery(String firstName, Long id) {
		// TODO Auto-generated method stub
		return userRepository.updateUserQuery(firstName,id);
	}




}
