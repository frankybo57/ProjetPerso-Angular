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
import noyau.repositories.ModuleRepository;

@RestController
public class ModuleController {
	@Autowired
	private ModuleRepository modRepo;
	
	@GetMapping("/modules-actifs")
	@JsonView(Views.Module.class)
	public ResponseEntity<List<Module>> findAllModulesActifs() {
		for(Module module : modRepo.findAllByEtat(Etat.Actif)) {
			System.out.println(module.toString());
		}
		return new ResponseEntity<List<Module>>(modRepo.findAllByEtat(Etat.Actif), HttpStatus.OK);
	}
	
	@GetMapping("/modules")
	@JsonView(Views.Module.class)
	public ResponseEntity<List<Module>> findAll() {
		return new ResponseEntity<List<Module>>(modRepo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/modules/{id}")
	@JsonView(Views.Module.class)
	public ResponseEntity<Module> findOne(@PathVariable("id") Integer id) {
		Module tmp = (Module) modRepo.findOne(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/modules")
	@JsonView(Views.Module.class)
	public ResponseEntity<Module> create(@RequestBody Module obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		obj = modRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

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
		Module tmp = (Module) modRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			modRepo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/etats")
	public ResponseEntity<Etat[]> findAllEtats() {
		return new ResponseEntity<Etat[]>(Etat.values(), HttpStatus.OK);
	}
}
