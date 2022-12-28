package project.spring.repository;




import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import project.spring.entites.Login;

@Repository
public interface LoginRepository extends CrudRepository <Login , String>{

	Login findByUserId(String userId);

}
