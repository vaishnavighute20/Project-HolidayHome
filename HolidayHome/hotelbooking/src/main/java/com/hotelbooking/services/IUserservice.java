package com.hotelbooking.services;



import com.hotelbooking.entity.User;
import java.util.*;

public interface IUserservice {
User signUp(User user);
List<User> getAllUsers();
User getUserById(Long id);
User getUserByEmail(String email);
void deleteUser(Long id);
}
