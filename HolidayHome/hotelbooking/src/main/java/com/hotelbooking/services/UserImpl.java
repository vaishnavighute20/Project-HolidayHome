package com.hotelbooking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotelbooking.entity.Role;
import com.hotelbooking.entity.User;
import com.hotelbooking.repo.UserDao;

import jakarta.transaction.Transactional;

@Service

public class UserImpl implements IUserservice {
@Autowired
private PasswordEncoder passwordencoder;
@Autowired
private UserDao userRepository;

@Override
public User signUp(User user) {
	// TODO Auto-generated method stub
	 

	if(user!=null) {
		user.setPassword(passwordencoder.encode(user.getPassword()));
		user.setRole(user.getRole()!=null?user.getRole():Role.GUEST);
		User newadduser =userRepository.save(user);
		return newadduser;
	}
	
	return null;
}

@Override
public List<User> getAllUsers() {
	
	return userRepository.findAll();
}

@Override
public User getUserById(Long id) {
	// TODO Auto-generated method stub
	return userRepository.findById(id).get();
}

@Override
public User getUserByEmail(String email) {
	// TODO Auto-generated method stub
	return userRepository.findByEmail(email).get();
}

@Override
public void deleteUser(Long id) {
	if(id!=null)
		userRepository.deleteById(id);
	
	
}

}
