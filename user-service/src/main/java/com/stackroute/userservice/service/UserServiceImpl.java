package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExistException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   @Override
   public User saveUser(User user) throws UserAlreadyExistException {
       if(userRepository.existsById(user.getId()))
       {
           throw  new UserAlreadyExistException("User already exist ");
       }
       User savedUser=userRepository.save(user);
       if(savedUser == null)
       {
           throw new UserAlreadyExistException("User already exist ");
       }
       return savedUser;
   }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) throws UserNotFoundException {
       User user1 =null;
       if(userRepository.existsById(id))
       {
           user1=userRepository.findById(id).get();
           if(user1==null){
               throw new UserNotFoundException("User Not Found");
           }
       }
        return user1;
    }

    @Override
    public User findByName(String firstName) throws UserNotFoundException{
       User user=null;
       user=userRepository.findByName(firstName);
       if(user==null){
           throw new UserNotFoundException("User not found");
       }
       return user;
    }
}
