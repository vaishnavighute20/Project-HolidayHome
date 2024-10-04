package com.hotelbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.dto.LoginDto;
import com.hotelbooking.dto.ResponseDto;
import com.hotelbooking.entity.User;
import com.hotelbooking.services.IUserservice;
import com.hotelbooking.utils.JwtUtils;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private IUserservice userservice;
	@Autowired
	private AuthenticationManager authmanager;
	@Autowired
	private JwtUtils utils;
@PostMapping("/signup")
public ResponseEntity<?> signup(@RequestBody User user){
	User newuser=userservice.signUp(user);
	if(newuser!=null)
	return ResponseEntity.ok(newuser);
	return null;	
}
@GetMapping("/home")
public ResponseEntity<?> home(){
	return ResponseEntity.ok("welcome");
}
@PostMapping("/signin")
public ResponseEntity<?> signin(@RequestBody LoginDto logindto)
{
	System.out.println("in signin "+logindto.getEmail()+" "+logindto.getPassword());
	Authentication principal=authmanager.authenticate(new UsernamePasswordAuthenticationToken(logindto.getEmail(), logindto.getPassword()));
	String jwttoken=utils.generatToken(principal);
	return ResponseEntity.ok(new ResponseDto(jwttoken,logindto.getEmail()));
}

@GetMapping("/{id}")
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<User> getUserById(@PathVariable Long id) {
    User user = userservice.getUserById(id);
    if (user != null) {
        return ResponseEntity.ok(user);
    } else {
        return ResponseEntity.notFound().build();
    }
}
@PutMapping("/{id}")
public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
    User user = userservice.getUserById(id);
    if (user != null) {
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        user.setMobile(userDetails.getMobile());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setGender(userDetails.getGender());
        user.setBookings(userDetails.getBookings());
        user.setReviews(userDetails.getReviews());
        return ResponseEntity.ok(userservice.signUp(user));
    } else {
        return ResponseEntity.notFound().build();
    }
}
@DeleteMapping("/{id}")
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userservice.deleteUser(id);
    return ResponseEntity.noContent().build();
}

/*//for frontend
@GetMapping("/details")
@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
public ResponseEntity<?> getUserDetails(Authentication authentication) {
    String email = authentication.getName();
    User user = userservice.getUserByEmail(email);
    if (user != null) {
        return ResponseEntity.ok(user);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}*/

}
