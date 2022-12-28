package project.spring.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TacheDto {
	private Long id;
	private String Nom;
	private String Date_debut;
	private String date_fin;
	private String responsable;


}
