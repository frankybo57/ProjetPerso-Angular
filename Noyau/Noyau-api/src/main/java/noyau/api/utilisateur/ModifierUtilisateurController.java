package noyau.api.utilisateur;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import constantes.Constantes;
import exception.UtilisateurException;
import noyau.model.Utilisateur;
import noyau.model.Views;
import noyau.service.UtilisateurService;

@RestController
public class ModifierUtilisateurController {

	@Autowired
	private UtilisateurService utiService;

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
		Map utilisateurJson = (Map) obj.get(Constantes.UTILISATEUR);
		Utilisateur utilisateur = utiService.getUtilisateurFromJson(utilisateurJson);

		String nouveauLogin = (String) obj.get(Constantes.LOGIN);

		if(nouveauLogin == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			utiService.update(utilisateur, nouveauLogin, Constantes.LOGIN, false);
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
		Map utilisateurJson = (Map) obj.get(Constantes.UTILISATEUR);
		Utilisateur utilisateur = utiService.getUtilisateurFromJson(utilisateurJson);

		String nouveauLogin = (String) obj.get(Constantes.LOGIN);

		if(nouveauLogin == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			utiService.update(utilisateur, nouveauLogin, Constantes.LOGIN, true);
			return new ResponseEntity<>(utilisateur, HttpStatus.CREATED);
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
	@PutMapping("/utilisateur/update/password/")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> updatePassword(@RequestBody final Map obj) {
		if (obj == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Map utilisateurJson = (Map) obj.get(Constantes.UTILISATEUR);
		Utilisateur utilisateur = utiService.getUtilisateurFromJson(utilisateurJson);

		String nouveauPassword = (String) obj.get(Constantes.MOT_DE_PASSE);

		if(nouveauPassword == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			utiService.update(utilisateur, nouveauPassword, Constantes.MOT_DE_PASSE, false);
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
	@PutMapping("/utilisateur/code/update/password/")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> updateCodePassword(@RequestBody final Map obj) {
		if (obj == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Map utilisateurJson = (Map) obj.get(Constantes.UTILISATEUR);
		Utilisateur utilisateur = utiService.getUtilisateurFromJson(utilisateurJson);

		String nouveauPassword = (String) obj.get(Constantes.MOT_DE_PASSE);

		if(nouveauPassword == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			utiService.update(utilisateur, nouveauPassword, Constantes.MOT_DE_PASSE, true);
			return new ResponseEntity<>(utilisateur, HttpStatus.CREATED);
		}
		catch(UtilisateurException ue) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
