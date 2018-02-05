package noyau.api.utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import exception.UtilisateurException;
import noyau.model.Utilisateur;
import noyau.model.Views;
import noyau.service.UtilisateurService;

@RestController
public class TrouverUtilisateur {

	@Autowired
	private UtilisateurService utiService;
	
	/**
	 * Méthode de récupération d'un utilisateur à partir de son nom d'utilisateur et de son mot de passe sans hashage du mot de passe.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param login
	 * 		Nom d'utilisateur.
	 * @param password
	 * 		Mot de passe.
	 * @return
	 * 		HttpStatus.OK + Utilisateur si l'utilisateur est trouvé.
	 * 		ou
	 * 		HttpStatus.NOT_FOUND si l'utilisateur n'est pas trouvé.
	 * 		
	 */
	@GetMapping("/utilisateur/{login}:{password}")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> findOne(@PathVariable("login") final String login, @PathVariable("password") final String password){
		Utilisateur tmp;

		try {
			tmp = utiService.findOne(login,password,false);
			tmp.setPassword("");
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} catch(UtilisateurException ue) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * Méthode de récupération d'un utilisateur à  partir de son nom d'utilisateur et de son mot de passe avec hashage du mot de passe.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param login
	 * 		Nom d'utilisateur.
	 * @param password
	 * 		Mot de passe.
	 * @return
	 * 		HttpStatus.OK + Utilisateur si l'utilisateur est trouvé.
	 * 		ou
	 * 		HttpStatus.NOT_FOUND si l'utilisateur n'est pas trouvé.
	 * 		
	 */
	@GetMapping("/utilisateur/code/{login}:{password}")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> findOneCode(@PathVariable("login") final String login, @PathVariable("password") final String password){
		try {
			final Utilisateur tmp = utiService.findOne(login,password,true);
			tmp.setPassword("");
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} catch(UtilisateurException ue) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
