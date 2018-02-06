package noyau.api.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import noyau.model.Module;
import noyau.model.Views;
import noyau.service.ModuleService;

@RestController
public class AjouterModuleController {

	@Autowired
	ModuleService modService;
	
	/**
	 * Méthode de création en base d'un nouveau module.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj module a créer
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
		obj = modService.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

}
