package ejemplo.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejemplo.mongodb.model.Persona;
import ejemplo.mongodb.repository.IPersonaRepository;

@Service
public class PersonaService {
	
	@Autowired
	private IPersonaRepository repo;
	
	public Persona crear(String nombre, String apellido, int edad) {
		return repo.save(new Persona(nombre, apellido, edad));		
	}
	
	public List<Persona> getAll() {
		return repo.findAll();
	}
	
	public Persona getByNombre(String nombre) {
		return repo.findByNombre(nombre);
	}
	
	public Persona actualizar(String nombre, String apellido, int edad) {
		Persona p = repo.findByNombre(nombre);
		p.setApellido(apellido);
		p.setEdad(edad);
		return repo.save(p);
	}
	
	public void deleteAll() {
		repo.deleteAll();
	}
	
	public void delete(String nombre) {
		Persona p = repo.findByNombre(nombre);
		repo.delete(p);
		
	}

}
