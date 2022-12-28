package project.spring.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	private String nom;
	private String email;
	private float salaire;
	private int tel;
	private String post;
	private String age;
	private String adresse;
	private String gender;
	
	 
	@OneToMany(mappedBy = "user")
	  private List<Tache> tache = new ArrayList<>();
	
}
