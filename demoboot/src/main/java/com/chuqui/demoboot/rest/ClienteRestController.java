package com.chuqui.demoboot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.chuqui.demoboot.modelo.clientes;
import com.chuqui.demoboot.modelo.user;
import com.chuqui.demoboot.service.clienteService;

@RestController
public class ClienteRestController {
	
	 @Autowired
	    clienteService clienteService;
	 
	 
	   @RequestMapping(value = "/cliente/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createCliente(@RequestBody clientes cliente,    UriComponentsBuilder ucBuilder) {
	       
	 
	        if (clienteService.isclientesExist(cliente)) {	       
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        clienteService.saveclientes(cliente);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	   
	   
	   
	   


}
