package com.example.spring.Service;


import java.util.List;

import com.example.spring.model.Employee;

public interface ApiService {
	public boolean addTask(Employee task);
	public boolean updateTask(Long id  ,Employee task);
	public List<Employee> getTask();
}
