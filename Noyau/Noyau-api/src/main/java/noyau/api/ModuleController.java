package noyau.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import noyau.model.Etat;
import noyau.model.Module;
import noyau.model.Views;
import noyau.repository.ModuleRepository;

@RestController
public class ModuleController {
	@Autowired
	private ModuleRepository modRepo;
	
	/**
	 * Méthode de récupération de tous les modules actifs.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @return
	 * 		HttpStatus.OK + List<Module> liste des modules actifs.
	 * 		ou
	 * 		HttpStatus.NOT_FOUND si aucun module actif n'est trouvé.
	 * 		
	 */
	@GetMapping("/modules-actifs")
	@JsonView(Views.Module.class)
	public ResponseEntity<List<Module>> findAllModulesActifs() {
		List temp = modRepo.findAllByEtat(Etat.ACTIF);
		if(temp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(modRepo.findAllByEtat(Etat.ACTIF), HttpStatus.OK);
		}
	}
	
	/**
	 * Méthode de récupération de tous les modules.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @return
	 * 		HttpStatus.OK + List<Module> liste des modules.
	 * 		ou
	 * 		HttpStatus.NOT_FOUND si aucun module n'est trouvé.
	 * 		
	 */
	@GetMapping("/modules")
	@JsonView(Views.Module.class)
	public ResponseEntity<List<Module>> findAll() {
		List temp = modRepo.findAllByEtat(Etat.ACTIF);
		if(temp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(modRepo.findAll(), HttpStatus.OK);
		}
	}
	
	/**
	 * Méthode de récupération d'un module à partir de son id.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param id
	 * @return
	 * 		HttpStatus.OK + List<Module> module.
	 * 		ou
	 * 		HttpStatus.NOT_FOUND si le module n'est pas trouvé.
	 * 		
	 */
	@GetMapping("/modules/{id}")
	@JsonView(Views.Module.class)
	public ResponseEntity<Module> findOne(@PathVariable("id") Integer id) {
		Module tmp = modRepo.findOne(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Méthode de création en base d'un nouveau module.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param module
	 * @return
	 * 		HttpStatus.CREATED + Module
	 * 		ou
	 * 		HttpStatus.BAD_REQUEST si le module n'est pas créé.
	 * 		
	 */
	@PostMapping("/modules")
	@JsonView(Views.Module.class)
	public ResponseEntity<Module> create(@RequestBody Module obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		obj = modRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	/**
	 * Méthode de mise à jour en base d'un module.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param module
	 * @return
	 * 		HttpStatus.OK + Module module.
	 * 		
	 */
	@PutMapping("/modules")
	@JsonView(Views.Module.class)
	public ResponseEntity<Module> update(@RequestBody Module obj) {
		if (obj.getId() == null) {
			return create(obj);
		}
		obj = modRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/modules/{id}")
	@JsonView(Views.Module.class)
	public ResponseEntity<Module> delete(@PathVariable("id") Integer id) {
		Module tmp = modRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			modRepo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/etats")
	public ResponseEntity<Etat[]> findAllEtats() {
		return new ResponseEntity<>(Etat.values(), HttpStatus.OK);
	}
}
