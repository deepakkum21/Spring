package com.deepak.springsecurityjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.springsecurityjwt.models.AuthenticationRequest;
import com.deepak.springsecurityjwt.models.AuthenticationResponse;
import com.deepak.springsecurityjwt.services.MyUserDetailsService;
import com.deepak.springsecurityjwt.util.JwtUtil;

@RestController
public class HelloResource {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/hello")
	public String hello() {
		return "Welcome to Spring Security with JWT";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException exp) {
			throw new Exception("Bad Credentials Exception", exp);
		}
		
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		
		final String jwt = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
