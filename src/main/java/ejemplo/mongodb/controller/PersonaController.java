package ejemplo.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejemplo.mongodb.model.Persona;
import ejemplo.mongodb.service.PersonaService;

@RestController
public class PersonaController {
	
	@Autowired
	private PersonaService servicio;
	
	@RequestMapping("/crear")
	public String crear(@RequestParam String nombre, @RequestParam String apellido, @RequestParam int edad) {
		Persona p = servicio.crear(nombre, apellido, edad);
		return p.toString();		
	}
	
	@RequestMapping("/get")
	public Persona getPersona(@RequestParam String nombre) {
		return servicio.getByNombre(nombre);
	}
	
	@RequestMapping("/getAll")
	public List<Persona> getAll() {
		return servicio.getAll();
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@RequestParam String nombre, @RequestParam String apellido, @RequestParam int edad) {
		Persona p = servicio.actualizar(nombre, apellido, edad);
		return p.toString();
	}
	
	@RequestMapping("/borrar")
	public String borrar(@RequestParam String nombre) {
		servicio.delete(nombre);
		return "Borrado: " + nombre;
	}
	
	@RequestMapping("/borrarTodos")
	public String borrar() {
		servicio.deleteAll();
		return "Borrados todos los registros";
	}
	
	

}
