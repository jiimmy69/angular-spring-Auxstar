package project.spring.service;

import java.util.List;

import project.spring.entites.User;

public interface UserService {

	
	
	
	User ajouterUser(User u);
	User updateUser(Long id,User user);
	User findByIdUser(Long id);
	void deleteUser(User u);
	void deleteUser(Long id);
	List < User> getAllUser();
}
