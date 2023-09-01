package com.day6.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.day6.model.Child;



public interface ApiService {

public boolean adduser(Child child);
public boolean updateuser(Long babyId, Child child);
boolean deleteUser(Long babyId);
public Page<Child> getAllUser(PageRequest pageRequest);
}
