package project.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.entites.Tache;
import project.spring.repository.TacheRepository;

@Service
public class TacheServiceImpl implements TacheService {
@Autowired
TacheRepository tacheRepository;

@Override
public Tache ajouterTache(Tache tache) {
	// TODO Auto-generated method stub
	return tacheRepository.save(tache);
}

@Override
public Tache updateTache(Long id, Tache tache) {
	tache.setId(id);
	return tacheRepository.save(tache);
}

@Override
public Tache findByIdTache(Long id) {

	Optional<Tache> tache=tacheRepository.findById(id);
	if ( tache.isPresent()) {
		return tache.get();
	}
	return null;
}

@Override
public void deleteTache(Tache tache) {
	tacheRepository.delete(tache);
	
}

@Override
public void deleteTache(Long id) {
	tacheRepository.deleteById(id);
	
}

@Override
public List<Tache> getAllTache() {
	return (List<Tache>) tacheRepository.findAll();

}

}
