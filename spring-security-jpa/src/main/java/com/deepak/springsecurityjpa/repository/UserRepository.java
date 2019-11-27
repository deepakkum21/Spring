package com.deepak.springsecurityjpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepak.springsecurityjpa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUserName(String userName);

}
