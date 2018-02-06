package noyau.api.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import noyau.model.Module;
import noyau.model.Views;
import noyau.service.ModuleService;

@RestController
public class TrouverModuleController {

	@Autowired
	ModuleService modService;
	
	/**
	 * Méthode de récupération d'un module à partir de son id.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param id du module recherché.
	 * @return
	 * 		HttpStatus.OK + Module.
	 * 		ou
	 * 		HttpStatus.NOT_FOUND si le module n'est pas trouvé.
	 * 		
	 */
	@GetMapping("/modules/{id}")
	@JsonView(Views.Module.class)
	public ResponseEntity<Module> findOne(@PathVariable("id") final Long id) {
		final Module tmp = modService.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		}
	}

}
