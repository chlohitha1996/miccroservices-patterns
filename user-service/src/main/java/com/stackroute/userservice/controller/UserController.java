package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExistException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.repository.UserRepository;
import com.stackroute.userservice.service.UserService;
import javassist.bytecode.stackmap.BasicBlock;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("User")
    public ResponseEntity<?> saveUser(@RequestBody User user)
    {
        ResponseEntity responseEntity;
        try {
            userService.saveUser(user);
            responseEntity=new ResponseEntity<String>("Successfully created ", HttpStatus.CREATED);
        }
        catch (/*Exception*/UserAlreadyExistException ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return  responseEntity;
    }
    @GetMapping("User")
    public ResponseEntity<?> getAllUsers()
    {
        return  new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("User1/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id)
    {
        ResponseEntity responseEntity;
        try {
            User user=userService.findById(id);
            if(user==null){
                responseEntity=new ResponseEntity<String>("User Not found",HttpStatus.OK);
            }
            else {
                responseEntity = new ResponseEntity<String>("User found", HttpStatus.OK);
            }
        }
        catch(UserNotFoundException ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return  responseEntity;
    }

    @GetMapping("User2/{firstName}")
    public ResponseEntity<?> findByName(@PathVariable("firstName") String firstName){
        ResponseEntity responseEntity;
        try {
            User user=userService.findByName(firstName);
            if(user==null){
                responseEntity=new ResponseEntity<String>("User Not found",HttpStatus.CONFLICT);
            }
            else {
                responseEntity = new ResponseEntity<String>("User found", HttpStatus.OK);
            }
        }
        catch(UserNotFoundException ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
