package com.chuqui.demoboot.rest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.chuqui.demoboot.modelo.user;
import com.chuqui.demoboot.service.*;

@RestController
public class UserRestController {
	 @Autowired
	    UserService userService;
	 
	 
	   @RequestMapping(value = "/user/", method = RequestMethod.GET)
	    public ResponseEntity<List<user>> listAllUsers() {
	        List<user> users = userService.findAllUsers();
	        if(users.isEmpty()){
	            return new ResponseEntity<List<user>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<user>>(users, HttpStatus.OK);
	    }
	   
	   
	   @RequestMapping(value = "/user/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUser(@RequestBody user User,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating User " + User.getUsername());
	 
	        if (userService.isUserExist(User)) {
	            System.out.println("A User with name " + User.getUsername() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        userService.saveUser(User);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(User.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	   
	   @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<user> updateUser(@PathVariable("id") long id, @RequestBody user User) {
	        System.out.println("Updating User " + id);
	         
	        user currentUser = userService.findById(id);
	         
	        if (currentUser==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<user>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentUser.setUsername(User.getUsername());
	        currentUser.setAddress(User.getAddress());
	        currentUser.setEmail(User.getEmail());
	         
	        userService.updateUser(currentUser);
	        return new ResponseEntity<user>(currentUser, HttpStatus.OK);
	    }
	    
	    
	    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<user> deleteUser(@PathVariable("id") long id) {
	        System.out.println("Fetching & Deleting User with id " + id);
	 
	        user user = userService.findById(id);
	        if (user == null) {
	            System.out.println("Unable to delete. User with id " + id + " not found");
	            return new ResponseEntity<user>(HttpStatus.NOT_FOUND);
	        }
	 
	        userService.deleteUserById(id);
	        return new ResponseEntity<user>(HttpStatus.NO_CONTENT);
	    }
	   
	    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	    public ResponseEntity<user> deleteAllUsers() {
	        System.out.println("Deleting All Users");
	 
	        userService.deleteAllUsers();
	        return new ResponseEntity<user>(HttpStatus.NO_CONTENT);
	    }
}
