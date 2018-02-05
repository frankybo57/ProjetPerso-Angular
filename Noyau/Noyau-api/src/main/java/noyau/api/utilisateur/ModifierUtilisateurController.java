package noyau.api.utilisateur;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import exception.UtilisateurException;
import noyau.model.Utilisateur;
import noyau.model.Views;
import noyau.service.UtilisateurService;

@RestController
public class ModifierUtilisateurController {

	@Autowired
	private UtilisateurService utiService;
	
	/**
	 * Méthode d'update d'un utilisateur sans hashage.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj
	 * 		Utilisateur à créer.
	 * @return
	 * 		HttpStatus.CREATED + Utilisateur si l'utilisateur est trouvé.
	 * 		ou
	 * 		HttpStatus.INTERNAL_SERVER_ERROR si l'utilisateur n'est pas trouvé.
	 * 		
	 */
	@PutMapping("/utilisateur/")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> update(@RequestBody final Utilisateur obj) {

		try {
			utiService.update(obj,false);
			return new ResponseEntity<>(obj, HttpStatus.CREATED);
		}
		catch(UtilisateurException ue) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Méthode d'update d'un utilisateur avec hashage.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj
	 * 		Utilisateur à créer.
	 * @return
	 * 		HttpStatus.CREATED + Utilisateur si l'utilisateur est trouvé.
	 * 		ou
	 * 		HttpStatus.INTERNAL_SERVER_ERROR si l'utilisateur n'est pas trouvé.
	 * 		
	 */
	@PutMapping("/utilisateur/code")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> updateCode(@RequestBody final Utilisateur obj) {

		try {
			utiService.update(obj,true);
			return new ResponseEntity<>(obj, HttpStatus.CREATED);
		}
		catch(UtilisateurException ue) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	

	/**
	 * Méthode d'update du login d'un utilisateur sans hashage.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj Utilisateur à créer.
	 * @param login nouveau login.
	 * @return
	 * 		HttpStatus.CREATED + Utilisateur si l'utilisateur est trouvé.
	 * 		ou
	 * 		HttpStatus.INTERNAL_SERVER_ERROR si l'utilisateur n'est pas trouvé.
	 * 		
	 */
	@SuppressWarnings("rawtypes")
	@PutMapping("/utilisateur/update/login/")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> updateLogin(@RequestBody final Map obj) {
		if (obj == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Map utilisateurJson = (Map) obj.get("utilisateur");
		Utilisateur utilisateur = utiService.getUtilisateurFromJson(utilisateurJson);

		String nouveauLogin = (String) obj.get("login");

		if(nouveauLogin == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			utiService.updateLogin(utilisateur, nouveauLogin, false);
			return new ResponseEntity<>(utilisateur, HttpStatus.CREATED);
		}
		catch(UtilisateurException ue) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Méthode d'update du login d'un utilisateur avec hashage.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj Utilisateur à créer.
	 * @param login nouveau login.
	 * @return
	 * 		HttpStatus.CREATED + Utilisateur si l'utilisateur est trouvé.
	 * 		ou
	 * 		HttpStatus.INTERNAL_SERVER_ERROR si l'utilisateur n'est pas trouvé.
	 * 		
	 */
	@SuppressWarnings("rawtypes")
	@PutMapping("/utilisateur/code/update/login/")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> updateCodeLogin(@RequestBody final Map obj) {
		if (obj == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Map utilisateurJson = (Map) obj.get("utilisateur");
		Utilisateur utilisateur = utiService.getUtilisateurFromJson(utilisateurJson);

		String nouveauLogin = (String) obj.get("login");

		if(nouveauLogin == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			utiService.updateLogin(utilisateur, nouveauLogin, true);
			return new ResponseEntity<>(utilisateur, HttpStatus.CREATED);
		}
		catch(UtilisateurException ue) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
