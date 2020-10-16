package ejemplo.mongodb.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ejemplo.mongodb.model.Persona;

@Repository
public interface IPersonaRepository extends MongoRepository<Persona, String> {
	
	public Persona findByNombre(String nombre);
	public List<Persona> findByEdad(int edad);

}
