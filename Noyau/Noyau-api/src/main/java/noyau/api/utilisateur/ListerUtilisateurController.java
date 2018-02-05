package noyau.api.utilisateur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import noyau.model.Utilisateur;
import noyau.model.Views;
import noyau.service.UtilisateurService;


@RestController
public class ListerUtilisateurController {
	
	@Autowired
	private UtilisateurService utiService;	

	/**
	 * Méthode de récupération de tous utilisateurs.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @return liste des utilisateurs
	 * 		
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/utilisateur/liste")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<List<Utilisateur>> findAll(){
		try {
			final List<Utilisateur> tmp = utiService.findAll();
			if(tmp.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			for(Utilisateur utilisateur : tmp) {
				utilisateur.setPassword(null);
			}
			return new ResponseEntity<>(tmp,HttpStatus.OK);
		}
		catch(final Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
