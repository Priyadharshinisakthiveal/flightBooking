package com.flight.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.entities.Role;
import com.flight.entities.Roles;
import com.flight.entities.SignupRequest;
import com.flight.entities.Users;
import com.flight.repository.RolesRepository;
import com.flight.repository.UserRepository;

@RestController
@RequestMapping("/authorize")
public class ILoginController {
	@Autowired
	UserRepository repository;
	@Autowired
	RolesRepository rolerepository;
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/usersignup")
	public ResponseEntity<?> userSignup(@RequestBody SignupRequest signupRequest) {
		if(repository.existsByUserName(signupRequest.getUserName())){
	      return ResponseEntity.badRequest().body("login");
	    }
	   
	    Users user = new Users();
	    Set<Role> roles = new HashSet<>();
	    user.setUsername(signupRequest.getUserName());
	    user.setPassword(encoder.encode(signupRequest.getPassword()));
	    System.out.println("Encoded password--- " + user.getPassword());
	    String[] roleArr = signupRequest.getRoles();
	    
	    if(roleArr == null) {
	      roles.add(rolerepository.findByRoleName(Roles.ROLE_USER).get());
	    }
	    for(String role: roleArr) {
	      switch(role) {
	        case "admin":
	          roles.add(rolerepository.findByRoleName(Roles.ROLE_ADMIN).get());
	          break;
	        case "user":
	          roles.add(rolerepository.findByRoleName(Roles.ROLE_USER).get());
	          break;  
	        default:
	          return ResponseEntity.badRequest().body("Specified role not found");
	      }
	    }
	    user.setRoles(roles);
	    repository.save(user);
	    return ResponseEntity.ok("User signed up successfully");
	}
}
