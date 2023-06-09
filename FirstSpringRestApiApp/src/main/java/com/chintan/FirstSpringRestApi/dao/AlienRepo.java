package com.chintan.FirstSpringRestApi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chintan.FirstSpringRestApi.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {
	
	List<Alien> findByAname(String aname);
	
	List<Alien> findAllByAidGreaterThan(int aid);
	
	@Query("from Alien where aid!=?1 order by aname desc")
	List<Alien> anyMethodName(int aid);
}
