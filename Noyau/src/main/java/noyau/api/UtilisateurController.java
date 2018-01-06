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

import noyau.Verrou;
import noyau.exception.UtilisateurException;
import noyau.model.Droit;
import noyau.model.Utilisateur;
import noyau.model.Views;
import noyau.repositories.UtilisateurRepository;

@RestController
public class UtilisateurController {
	@Autowired
	private UtilisateurRepository utiRepo;
	
	/**
	 * Logger de la classe.
	 */
//	private static final Logger logger = LogManager.getLogger(UtilisateurController.class);
	private static final String UTILISATEUR_NON_TROUVE = "Utilisateur non trouvé.";
	private static final String NOUVEL_UTILISATEUR_AVEC_ID ="Problème : le nouvel utilisateur ne devrait pas avoir d'id.";
	private static final String UTILISATEUR_SANS_ID ="Problème : l'utilisateur devrait avoir un id.";
	private static final String TENTATIVE_CREATION = "Tentative de création d'un nouvel utilisateur : ";
	private static final String TENTATIVE_UPDATE = "Tentative d'update de l'utilisateur : ";
	private static final String DROITS = ", avec les droits : ";
	
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
	public ResponseEntity<Utilisateur> findOne(@PathVariable("login") String login, @PathVariable("password") String password){
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
	public ResponseEntity<Utilisateur> findOneCode(@PathVariable("login") String login, @PathVariable("password") String password){
		Utilisateur tmp;
		
		try {
			tmp = findOne(login,password,true);
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
	 * 		Condition de hashage.
	 * @return Utilisateur
	 * 		
	 */
	private Utilisateur findOne(String login, String password, boolean hash) throws UtilisateurException{
		Utilisateur tmp;
		if(hash) {
			tmp = utiRepo.findOneByLoginAndByPassword(login,Verrou.cryptage(password));
		}
		else {
			tmp = utiRepo.findOneByLoginAndByPassword(login,password);
		}
		if (tmp != null) {
			tmp.setPassword("");
			return tmp;
		} else {
//			if(logger.isErrorEnabled()) {
//				logger.error(UTILISATEUR_NON_TROUVE);
//			}
			throw new UtilisateurException(UTILISATEUR_NON_TROUVE);
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
			return new ResponseEntity<>(utiRepo.findAllWithoutCode(),HttpStatus.OK);
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
	 * @throws UtilisateurException
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
	public ResponseEntity<Utilisateur> createOne(@RequestBody Utilisateur obj) throws UtilisateurException{
		try {
			obj = createOne(obj,false);
			return new ResponseEntity<>(obj, HttpStatus.CREATED);
		}catch(UtilisateurException ue) {
			if(NOUVEL_UTILISATEUR_AVEC_ID.equals(ue.getMessage())) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/utilisateur/code/")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> createOneCode(@RequestBody Utilisateur obj) throws UtilisateurException{
		try {
			obj = createOne(obj,true);
			return new ResponseEntity<>(obj, HttpStatus.CREATED);
		}catch(UtilisateurException ue) {
			if(NOUVEL_UTILISATEUR_AVEC_ID.equals(ue.getMessage())) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	private Utilisateur createOne(Utilisateur obj, boolean hash) throws UtilisateurException {
		String message;
		
		// Logging de la tentative de création.
//		if(logger.isInfoEnabled()) {
//			logger.info(TENTATIVE_CREATION + obj.getLogin() + DROITS + Droit.UTILISATEUR.getLabel());
//		}
		
		// Test d'unicité du login.
		if (utiRepo.findByLogin(obj.getLogin())!=null) {
			message = "Un compte avec le nom d'utilisateur \""+ obj.getLogin() + "\" existe déjà.";
			
//			if(logger.isInfoEnabled()) {
//				logger.info(message);
//			}
			
			throw new UtilisateurException(message);
		}
		
		// Test de nullité de l'id du nouvel utilisateur.
		if (obj.getId() != null) {
			
//			if(logger.isDebugEnabled()) {
//				logger.debug(NOUVEL_UTILISATEUR_AVEC_ID);
//			}
			
			throw new UtilisateurException(NOUVEL_UTILISATEUR_AVEC_ID);
		}
		
		// Hashage du mot de passe si nécessaire.
		if(hash) {
			obj.setPassword(Verrou.cryptage(obj.getPassword()));
		}
		
		obj.setDroits(Droit.UTILISATEUR);
		obj = utiRepo.save(obj);
		obj.setPassword("");
		
		// Logging de la création d'un utilisateur.
//		if(logger.isInfoEnabled()) {
//			logger.info("Un nouvel utilisateur : " + obj.getLogin()
//					+ DROITS + Droit.UTILISATEUR.getLabel()
//					+ "a été créé.");
//		}
		
		return obj;
	}
	
	/**
	 * Méthode d'update d'un utilisateur sans hashage.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @throws UtilisateurException
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
	public ResponseEntity<Utilisateur> update(@RequestBody Utilisateur obj) {
		
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
	 * @throws UtilisateurException
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
	public ResponseEntity<Utilisateur> updateCode(@RequestBody Utilisateur obj) {
		
		try {
			update(obj,true);
			return new ResponseEntity<>(obj, HttpStatus.CREATED);
		}
		catch(UtilisateurException ue) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	private Utilisateur update(Utilisateur obj, boolean hash) throws UtilisateurException{
		// Logging de la tentative d'update.
//		if(logger.isInfoEnabled()) {
//			logger.info(TENTATIVE_UPDATE + obj.getLogin() + DROITS + Droit.UTILISATEUR.getLabel());
//		}
		
		// Test de nullité de l'id du nouvel utilisateur.
		if(obj.getId() == null) {
//			if(logger.isDebugEnabled()) {
//				logger.debug(UTILISATEUR_SANS_ID);
//			}
			throw new UtilisateurException(UTILISATEUR_SANS_ID);
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
//			if(logger.isErrorEnabled()) {
//				logger.error("L'utilisateur" + obj.getLogin() + "n'a pas pu être mis à jour.");
//			}
			throw new UtilisateurException("L'utilisateur" + obj.getLogin() + "n'a pas pu être mis à jour.");
		}
		
		return obj;
	}
}
