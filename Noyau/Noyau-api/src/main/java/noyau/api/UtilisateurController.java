package noyau.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import constantes.Constantes;
import noyau.Verrou;
import noyau.exception.UtilisateurException;
import noyau.model.Droit;
import noyau.model.Utilisateur;
import noyau.model.Views;
import noyau.repository.UtilisateurRepository;


@RestController
public class UtilisateurController {
	@Autowired
	private UtilisateurRepository utiRepo;
	
	/**
	 * Méthode de récupération d'un utilisateur à partir de son nom d'utilisateur et de son mot de passe sans hashage du mot de passe.
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
			tmp = findOne(login,password,false);
			tmp.setPassword("");
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} catch(UtilisateurException ue) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	/**
	 * Méthode de récupération d'un utilisateur à partir de son nom d'utilisateur et de son mot de passe avec hashage du mot de passe.
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
			final Utilisateur tmp = findOne(login,password,true);
			tmp.setPassword("");
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} catch(UtilisateurException ue) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	/**
	 * Méthode de récupération d'un utilisateur à partir de son nom d'utilisateur et de son mot de passe avec ou sans hashage du mot de passe.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @throws UtilisateurException
	 * @param login
	 * 		Nom d'utilisateur.
	 * @param password
	 * 		Mot de passe.
	 * @param hash
	 * 		Si true alors hashage.
	 * @return Utilisateur
	 * 		
	 */
	private Utilisateur findOne(final String login, final String password, final boolean hash) throws UtilisateurException{
		Utilisateur tmp;
		if(hash) {
			tmp = utiRepo.findOneByLoginAndByPassword(login,Verrou.cryptage(password));
		}
		else {
			tmp = utiRepo.findOneByLoginAndByPassword(login,password);
		}
		if (tmp == null) {
			throw new UtilisateurException(Constantes.UTILISATEUR_NON_TROUVE);
		} else {
			tmp.setPassword("");
			return tmp;
		}
	}
	
	/**
	 * Méthode de récupération de tous utilisateurs.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @return liste des utilisateurs
	 * 		
	 */
	@GetMapping("/utilisateur/liste")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<List<Utilisateur>> findAll(){
		try {
			final List<Utilisateur> tmp = utiRepo.findAll();
			if(tmp.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			for(Utilisateur utilisateur : tmp) {
				utilisateur.setPassword(null);
			}
			return new ResponseEntity<>(tmp,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Méthode de création d'un utilisateur à partir de son nom d'utilisateur et de son mot de passe sans hashage du mot de passe.
	 * Si l'utilisateur est créé il reçoit des droits d'utilisateur de base.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj
	 * 		Utilisateur à créer.
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
			obj = createOne(obj,false);
			return new ResponseEntity<>(obj, HttpStatus.CREATED);
		}catch(UtilisateurException ue) {
			if(Constantes.NOUVEL_UTILISATEUR_AVEC_ID.equals(ue.getMessage())) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Méthode de création d'un utilisateur à partir de son nom d'utilisateur et de son mot de passe avec hashage du mot de passe.
	 * Si l'utilisateur est créé il reçoit des droits d'utilisateur de base.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj
	 * 		Utilisateur à créer.
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
			obj = createOne(obj,true);
			return new ResponseEntity<>(obj, HttpStatus.CREATED);
		}catch(UtilisateurException ue) {
			if(Constantes.NOUVEL_UTILISATEUR_AVEC_ID.equals(ue.getMessage())) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Méthode de création d'un utilisateur à partir de son nom d'utilisateur et de son mot de passe avec ou sans hashage du mot de passe.
	 * Si l'utilisateur est créé il reçoit des droits d'utilisateur de base.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj
	 * 		Utilisateur à créer.
	 * @param hash
	 * 		Si true alors hashage du mot de passe.
	 * @return
	 * 		Utilisateur créé.
	 * 		
	 */
	private Utilisateur createOne(Utilisateur obj, final boolean hash) throws UtilisateurException {
		String message;
		
		// Test d'unicité du login.
		if (utiRepo.findByLogin(obj.getLogin())!=null) {
			message = "Un compte avec le nom d'utilisateur \""+ obj.getLogin() + "\" existe déjà.";
			throw new UtilisateurException(message);
		}
		
		// Test de nullité de l'id du nouvel utilisateur.
		if (obj.getId() != null) {
			throw new UtilisateurException(Constantes.NOUVEL_UTILISATEUR_AVEC_ID);
		}
		
		// Hashage du mot de passe si nécessaire.
		if(hash) {
			obj.setPassword(Verrou.cryptage(obj.getPassword()));
		}
		
		obj.setDroits(Droit.UTILISATEUR);
		obj = utiRepo.save(obj);
		obj.setPassword("");
		
		return obj;
	}
	
	/**
	 * Méthode d'update d'un utilisateur sans hashage.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj
	 * 		Utilisateur à créer.
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
			update(obj,false);
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
	 * 		Utilisateur à créer.
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
			update(obj,true);
			return new ResponseEntity<>(obj, HttpStatus.CREATED);
		}
		catch(UtilisateurException ue) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	/**
	 * Méthode d'update d'un utilisateur avec ou sans hashage.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj
	 * 		Utilisateur à créer.
	 * @param hash
	 * 		Si true alors hashage.
	 * @return
	 * 		Utilisateur mis à jour.
	 * 		
	 */
	private Utilisateur update(final Utilisateur obj, final boolean hash) throws UtilisateurException{
		
		// Test de nullité de l'id du nouvel utilisateur.
		if(obj.getId() == null) {
			throw new UtilisateurException(Constantes.UTILISATEUR_SANS_ID);
		}
		
		// Hashage du mot de passe si nécessaire.
		if(hash) {
			obj.setPassword(Verrou.cryptage(obj.getPassword()));
		}
		
		try {
			// Tentative d'update de l'utilisateur.
			utiRepo.save(obj);
			obj.setPassword("");
		} catch(Exception e) {
			throw new UtilisateurException("L'utilisateur" + obj.getLogin() + "n'a pas pu être mis à jour.");
		}
		
		return obj;
	}
}
