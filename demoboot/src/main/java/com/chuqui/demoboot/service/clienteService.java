package com.chuqui.demoboot.service;

import java.util.List;

import com.chuqui.demoboot.modelo.clientes;
import com.chuqui.demoboot.modelo.user;

public interface clienteService {
	clientes findById(long id);
	
	clientes findByName(String name);
	
	void saveclientes(clientes cliente);
	
	void updateclientes(clientes cliente);
	
	void deletclientesById(long id);

	List<clientes> findAllclientes(); 
	
	void deleteAllclientes();
	
	public boolean isclientesExist(clientes cliente);
}
