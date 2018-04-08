package com.chuqui.demoboot.service;

import java.util.List;
import java.util.Optional;

import com.chuqui.demoboot.modelo.user;
public interface UserService {
	user findById(long id);
	
	user findByName(String name);
	
	void saveUser(user User);
	
	void updateUser(user User);
	
	void deleteUserById(long id);

	List<user> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(user User);
}
