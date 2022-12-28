package project.spring.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private long id;
	private String nom;
	private String email;
	private float salaire;
	private int tel;
	private String post;
	private String age;
	private String adresse;
	private String gender;
}
