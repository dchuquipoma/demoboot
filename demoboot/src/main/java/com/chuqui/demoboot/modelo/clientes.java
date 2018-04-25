package com.chuqui.demoboot.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity	
public class clientes {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nombre;
	
	@NotNull
	@Size(min=2, max=100)
	private String direccion;
	
	private String email;
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public clientes () {}
	


	@Override
	public String toString() {
		return "clientes [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", email=" + email + "]";
	}


	public clientes(long id, String nombre, String direccion, String email) {

		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.email = email;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clientes other = (clientes) obj;
		if (id != other.id)
			return false;
		return true;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	
	
}
