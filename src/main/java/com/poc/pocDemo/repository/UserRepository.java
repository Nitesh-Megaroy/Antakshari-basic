package com.poc.pocDemo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.poc.pocDemo.model.RegisterUser;

public interface UserRepository extends CrudRepository<RegisterUser, Long>{
	
	// Created to handle the username String, as by default findbyId is only present--->
	Optional<RegisterUser> findByUsername(String username);
}
