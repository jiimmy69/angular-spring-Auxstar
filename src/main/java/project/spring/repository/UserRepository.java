package project.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project.spring.entites.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByNom(String nom);
}
