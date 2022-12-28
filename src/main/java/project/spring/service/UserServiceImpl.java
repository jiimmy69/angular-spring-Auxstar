package project.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.entites.User;
import project.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public User ajouterUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(User u) {
		userRepository.delete(u);
		
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public List<User> getAllUser() {
		
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User updateUser(Long id,User user) {
		user.setId(id);
		return userRepository.save(user);
	}

	@Override
	public User findByIdUser(Long id) {
		Optional<User> user= userRepository.findById(id);
		if(user.isPresent()) {
		return user.get();
		}
		return null;
	}

	
	
	
}
