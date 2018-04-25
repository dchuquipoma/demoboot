package com.chuqui.demoboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.chuqui.demoboot.modelo.clientes;
import com.chuqui.demoboot.modelo.user;

public interface ClienteRepository extends CrudRepository<clientes, Long>  {
	clientes findBynombre(String name);

	clientes findById(long id);
}
