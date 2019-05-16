package com.stpl.deepak.springsecuritydemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stpl.deepak.springsecuritydemo.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	public User findByUserName(String userName);

}
