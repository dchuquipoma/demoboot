package com.chuqui.demoboot.service.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chuqui.demoboot.modelo.clientes;
import com.chuqui.demoboot.modelo.user;
import com.chuqui.demoboot.repository.ClienteRepository;
import com.chuqui.demoboot.repository.UserRepository;
import com.chuqui.demoboot.service.clienteService;

@Service("clienteService")
@Transactional
public class clienteServiceImpl implements clienteService {
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<clientes> clientess;
	
	@Autowired
	private ClienteRepository clienteRepository;
	

	@Override
	public clientes findById(long id) {
		// TODO Auto-generated method stub
		return  clienteRepository.findById(id);
	}

	@Override
	public clientes findByName(String name) {
		// TODO Auto-generated method stub
		return clienteRepository.findBynombre(name);
	}

	@Override
	public void saveclientes(clientes cliente) {
		clienteRepository.save(cliente);
		
	}

	@Override
	public void updateclientes(clientes cliente) {
		clienteRepository.save(cliente);
		
	}

	@Override
	public void deletclientesById(long id) {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

	@Override
	public List<clientes> findAllclientes() {
		// TODO Auto-generated method stub
		return (List<clientes>) clienteRepository.findAll();
	}

	@Override
	public void deleteAllclientes() {
		// TODO Auto-generated method stub
		clienteRepository.deleteAll();
		
	}

	@Override
	public boolean isclientesExist(clientes cliente) {
		// TODO Auto-generated method stub
		return findByName(cliente.getNombre())!=null;
	}

}
