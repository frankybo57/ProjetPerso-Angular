package noyau.api.utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import constantes.Constantes;
import exception.UtilisateurException;
import noyau.model.Utilisateur;
import noyau.model.Views;
import noyau.service.UtilisateurService;

@RestController
public class AjouterUtilisateurController {
	
	@Autowired
	UtilisateurService utiMan;

	/**
	 * Méthode de création d'un utilisateur à partir de son nom d'utilisateur et de son mot de passe sans hashage du mot de passe.
	 * Si l'utilisateur est créé il reà§oit des droits d'utilisateur de base.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj
	 * 		Utilisateur à créer.
	 * @return
	 * 		HttpStatus.CREATED + Utilisateur si l'utilisateur est trouvé.
	 * 		ou
	 * 		HttpStatus.NOT_FOUND si l'utilisateur n'est pas trouvé.
	 * 		
	 */
	@PostMapping("/utilisateur/")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> createOne(@RequestBody Utilisateur obj) {
		try {
			obj = utiMan.createOne(obj,false);
			return new ResponseEntity<>(obj, HttpStatus.CREATED);
		}catch(UtilisateurException ue) {
			if(Constantes.NOUVEL_UTILISATEUR_AVEC_ID.equals(ue.getMessage())) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Méthode de création d'un utilisateur à partir de son nom d'utilisateur et de son mot de passe avec hashage du mot de passe.
	 * Si l'utilisateur est créé il reçoit des droits d'utilisateur de base.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj
	 * 		Utilisateur à créer.
	 * @return
	 * 		HttpStatus.CREATED + Utilisateur si l'utilisateur est trouvé.
	 * 		ou
	 * 		HttpStatus.NOT_FOUND si l'utilisateur n'est pas trouvé.
	 * 		
	 */
	@PostMapping("/utilisateur/code/")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> createOneCode(@RequestBody Utilisateur obj) {
		try {
			obj = utiMan.createOne(obj,true);
			return new ResponseEntity<>(obj, HttpStatus.CREATED);
		}catch(UtilisateurException ue) {
			if(Constantes.NOUVEL_UTILISATEUR_AVEC_ID.equals(ue.getMessage())) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
