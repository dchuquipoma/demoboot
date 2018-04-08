package com.chuqui.demoboot.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chuqui.demoboot.modelo.user;
import com.chuqui.demoboot.repository.UserRepository;
import com.chuqui.demoboot.service.UserService;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<user> users;
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public user findById(long id) {
		return  userRepository.findById(id); //null;
		
	}

	@Override
	public user findByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(name);
	
	}

	@Override
	public void saveUser(user User) {
		userRepository.save(User);

	}

	@Override
	public void updateUser(user User) {
		userRepository.save(User);

	}

	@Override
	public void deleteUserById(long id) {
		userRepository.deleteById(id);

	}

	@Override
	public List<user> findAllUsers() {
		return (List<user>) userRepository.findAll();
	}

	@Override
	public void deleteAllUsers() {
		userRepository.deleteAll();

	}

	@Override
	public boolean isUserExist(user User) {
		// TODO Auto-generated method stub
		return findByName(User.getUsername())!=null;
	}

}
