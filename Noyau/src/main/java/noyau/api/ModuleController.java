package noyau.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
		return new ResponseEntity<List<Module>>(modRepo.findAllByEtat(Etat.Actif), HttpStatus.OK);
	}
}
