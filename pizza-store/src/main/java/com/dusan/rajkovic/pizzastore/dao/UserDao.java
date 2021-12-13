package com.dusan.rajkovic.pizzastore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dusan.rajkovic.pizzastore.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
	
	UserEntity findByUsername(String username);
	
}