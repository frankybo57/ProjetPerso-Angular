package noyau.api.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import exception.ModuleException;
import noyau.model.Module;
import noyau.model.Views;
import noyau.service.ModuleService;

@RestController
public class ModifierModuleController {

	@Autowired
	ModuleService modService;

	/**
	 * M�thode de mise � jour en base d'un module.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj module mis � jour
	 * @return
	 * 		HttpStatus.OK + Module module.
	 * 		
	 */
	@PutMapping("/modules")
	@JsonView(Views.Module.class)
	public ResponseEntity<Module> update(@RequestBody Module obj) {
		try {
			if (obj.getId() == null) {
				return new ResponseEntity<> (modService.save(obj), HttpStatus.CREATED);
			}
			obj = modService.update(obj);
		} catch (ModuleException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
}
