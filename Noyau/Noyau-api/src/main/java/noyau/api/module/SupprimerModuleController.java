package noyau.api.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import noyau.model.Module;
import noyau.model.Views;
import noyau.service.ModuleService;

@RestController
public class SupprimerModuleController {
	
	@Autowired
	ModuleService modService;

	@DeleteMapping("/modules/{id}")
	@JsonView(Views.Module.class)
	public ResponseEntity<Module> delete(@PathVariable("id") final Long id) {
		final Module tmp = modService.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			modService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
