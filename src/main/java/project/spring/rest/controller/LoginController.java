package project.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.spring.entites.Login;
import project.spring.repository.LoginRepository;

@RestController
@RequestMapping("/user")

public class LoginController {

	@Autowired
	private LoginRepository repo;
	@PostMapping("/user")
	public ResponseEntity<Login> loginUser (@RequestBody Login loginData){
		System.out.println(loginData);
		Login login=repo.findByUserId(loginData.getUserId());
		if (login.getPassword().equals(loginData.getPassword()))
			return ResponseEntity.ok(login);
		return (ResponseEntity<Login>) ResponseEntity.internalServerError();
		
	}
	
	
	
}
