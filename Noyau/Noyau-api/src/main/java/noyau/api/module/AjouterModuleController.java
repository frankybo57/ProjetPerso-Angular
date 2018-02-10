package noyau.api.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import exception.ModuleException;
import noyau.model.Module;
import noyau.model.Views;
import noyau.service.ModuleService;

@RestController
public class AjouterModuleController {

	@Autowired
	ModuleService modService;
	
	/**
	 * M�thode de cr�ation en base d'un nouveau module.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj module a cr�er
	 * @return
	 * 		HttpStatus.CREATED + Module
	 * 		ou
	 * 		HttpStatus.BAD_REQUEST si le module n'est pas cr��.
	 * 		
	 */
	@PostMapping("/modules")
	@JsonView(Views.Module.class)
	public ResponseEntity<Module> create(@RequestBody Module obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			obj = modService.save(obj);
		} catch (ModuleException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

}
