package project.spring.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import project.spring.entites.Tache;

@Repository
public interface TacheRepository extends CrudRepository <Tache, Long> {
	List<Tache> findByNom(String nom);
}