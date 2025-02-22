package com.rishi.journalApp.controller;

import com.rishi.journalApp.entity.JournalEntry;
import com.rishi.journalApp.entity.User;
import com.rishi.journalApp.service.JournalEntryService;
import com.rishi.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    //    special type of classes or components handle HTTP requests

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers(){ // localhost:8080/journal GET
        List<User> allUser = userService.getUsers();
        if(!allUser.isEmpty()){
            return new ResponseEntity<>(allUser, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User newUser){ // localhost:8080/journal POST
        try{
            userService.saveUser(newUser);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUserById(@RequestBody User newUser, @PathVariable String username){
        User currUser = userService.findByUsername(username);
        if(currUser != null){
            currUser.setUsername(!newUser.getUsername().isEmpty() ? newUser.getUsername() : currUser.getUsername());
            currUser.setPassword(!newUser.getPassword().isEmpty() ? newUser.getPassword() : currUser.getPassword());
            userService.saveUser(currUser);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @DeleteMapping("id/{myId}")
//    public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId myId) {
//        userService.deleteUser(myId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
