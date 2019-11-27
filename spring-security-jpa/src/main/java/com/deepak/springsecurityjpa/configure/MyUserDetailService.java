package com.deepak.springsecurityjpa.configure;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.deepak.springsecurityjpa.model.MyUserDetails;
import com.deepak.springsecurityjpa.model.User;
import com.deepak.springsecurityjpa.repository.UserRepository;

@Component
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// for dyanmic username with same password
		// return new MyUserDetails(username);
		
		Optional<User> myUser = userRepository.findByUserName(username);
//		if(myUser.isPresent()) {
//			return new MyUserDetails(myUser.get());
//		} else {
//			myUser.orElseThrow(() -> new UsernameNotFoundException("user not found: " + username));
//		}
		
		myUser.orElseThrow(() -> new UsernameNotFoundException("user not found: " + username));
		return myUser.map(MyUserDetails::new).get();
	}

}
