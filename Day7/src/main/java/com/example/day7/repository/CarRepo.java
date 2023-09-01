package com.example.day7.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.day7.model.Car;

public interface CarRepo extends JpaRepository<Car, Integer> {
	@Query(value="select * from cartable where owners=:own", nativeQuery = true)
	public List<Car> getCarInFromOwners(@Param("own") int own);
	
	@Query(value="select * from cartable where address=:addr", nativeQuery = true)
	public List<Car> getCarInFromAddress(@Param("addr") String address);
	
	@Query(value="select * from cartable where car_name=:namec", nativeQuery = true)
	public List<Car> getCarFromName(@Param("namec") String carname);
	
	@Query(value="select * from cartable where owners=:own and car_type=:ct", nativeQuery = true)
	public List<Car> getCarInFromOwnNCt(@Param("own") int owner,@Param("ct") String cType);
	
	
	
}