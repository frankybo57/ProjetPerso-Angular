package noyau.api.module;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import noyau.model.Etat;
import noyau.model.Views;
import noyau.service.ModuleService;

@RestController
public class ListerModuleController {

	@Autowired
	ModuleService modService;
	
	/**
	 * M�thode de r�cup�ration de tous les modules actifs.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @return
	 * 		HttpStatus.OK + Liste des modules actifs.
	 * 		ou
	 * 		HttpStatus.NOT_FOUND si aucun module actif n'est trouvé.
	 * 		
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/modules/actifs")
	@JsonView(Views.Module.class)
	public ResponseEntity<List> findAllModulesActifs() {
		final List tmp = modService.findAllByEtat(Etat.ACTIF);
		if(tmp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		}
	}
	
	/**
	 * Méthode de récupération de tous les modules triés par id.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @return
	 * 		HttpStatus.OK + Liste des modules triés.
	 * 		ou
	 * 		HttpStatus.NOT_FOUND si aucun module n'est trouvé.
	 * 		
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/modulesbyid")
	@JsonView(Views.Module.class)
	public ResponseEntity<List> findAllOrderById() {
		final List tmp = modService.findAllOrderByIdAsc();
		if(tmp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		}
	}
	
	/**
	 * Méthode de récupération de tous les modules.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @return
	 * 		HttpStatus.OK + Liste des modules.
	 * 		ou
	 * 		HttpStatus.NOT_FOUND si aucun module n'est trouvé.
	 * 		
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/modules")
	@JsonView(Views.Module.class)
	public ResponseEntity<List> findAll() {
		final List tmp = modService.findAll();
		if(tmp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		}
	}

}
