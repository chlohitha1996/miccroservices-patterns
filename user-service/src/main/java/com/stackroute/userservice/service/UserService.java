package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExistException;
import com.stackroute.userservice.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    /*public User saveUser(User user);*/
    public User saveUser(User user) throws UserAlreadyExistException;
    public List<User> getAllUsers();
    public User findById(int id) throws UserNotFoundException;
    public User findByName(String firstName) throws UserNotFoundException;
}
