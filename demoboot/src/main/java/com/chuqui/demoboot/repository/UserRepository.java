package com.chuqui.demoboot.repository;
import org.springframework.data.repository.CrudRepository;

import com.chuqui.demoboot.modelo.*;;


public interface UserRepository extends CrudRepository<user, Long> {
	user findByUsername(String name);

user findById(long id);
	

}
