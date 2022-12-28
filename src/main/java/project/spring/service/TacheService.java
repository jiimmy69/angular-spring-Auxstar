package project.spring.service;

import java.util.List;

import project.spring.entites.Tache;

public interface TacheService {

	Tache ajouterTache(Tache tache);
	Tache updateTache(Long id,Tache tache);
	Tache findByIdTache(Long id);
	void deleteTache(Tache tache);
	void deleteTache(Long id);
	List < Tache> getAllTache();
	
	
}
