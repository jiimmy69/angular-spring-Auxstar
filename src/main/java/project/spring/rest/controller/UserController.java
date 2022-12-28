package project.spring.rest.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project.spring.entites.User;
import project.spring.rest.dto.UserDto;
import project.spring.service.UserService;
import org.modelmapper.TypeToken;
@CrossOrigin("*")
@RestController
public class UserController {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UserService userService;
	
	//@RequestMapping(value = "/users" , method = RequestMethod.GET)
	@GetMapping("/users")
	@ResponseBody
	public List<User> getAllUsers(){
		List <User> list= userService.getAllUser();
		List <UserDto> listDto = modelMapper.map(list, new TypeToken<List<UserDto>>(){}.getType());
		return list;
	}
	
	//@RequestMapping(value = "/users" , method = RequestMethod.POST)
	@PostMapping("/users")
	public Object ajouterUser(@RequestBody() UserDto userDto ) {
		User user = modelMapper.map(userDto , User.class);
		 user=userService.ajouterUser(user);
		 userDto = modelMapper.map(user, UserDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
		
	}


	
	//@RequestMapping(value = "/users/{id}" , method = RequestMethod.PUT)
	@PutMapping("/users/{id}")
	public Object updateUser (@PathVariable("id") Long id , @RequestBody  UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		user = userService.updateUser(id, user);
		userDto=modelMapper.map(user, UserDto.class);
		 return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
		
	}

	@GetMapping("/users/{id}")
	public Object findByIdUser (@PathVariable("id") long id ) { 
		User user = userService.findByIdUser(id);
		UserDto userDto = modelMapper.map(user , UserDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(userDto);
	}
	
	
	@DeleteMapping("/users/{id}")
	@ResponseBody
	public Object deleteUser(@PathVariable("id") Long idUser) {
		userService.deleteUser(idUser);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
}
