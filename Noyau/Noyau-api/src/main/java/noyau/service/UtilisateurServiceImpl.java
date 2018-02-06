package noyau.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import constantes.Constantes;
import exception.UtilisateurException;
import noyau.model.Droit;
import noyau.model.Utilisateur;
import noyau.repository.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{
	
	@Autowired
	UtilisateurRepository utiRepo;
	
	/**
	 * Méthode de création d'un utilisateur à partir de son nom d'utilisateur et de son mot de passe avec ou sans hashage du mot de passe.
	 * Si l'utilisateur est créé il reçoit des droits d'utilisateur de base.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj
	 * 		Utilisateur à créer.
	 * @param hash
	 * 		Si true alors hashage du mot de passe.
	 * @return
	 * 		Utilisateur créé.
	 * 		
	 */
	@Override
	public Utilisateur createOne(Utilisateur obj, final boolean hash) throws UtilisateurException {
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
	
	@Override
	@SuppressWarnings("rawtypes")
	public List findAll() {
		return utiRepo.findAll();
	}
	
	/**
	 * Méthode de récupération d'un utilisateur à partir de son nom d'utilisateur et de son mot de passe avec ou sans hashage du mot de passe.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @throws UtilisateurException
	 * @param propriete
	 * 		Nom d'utilisateur.
	 * @param password
	 * 		Mot de passe.
	 * @param hash
	 * 		Si true alors hashage.
	 * @return Utilisateur
	 * 		
	 */
	@Override
	public Utilisateur findOne(final String login, final String password, final boolean hash) throws UtilisateurException{
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
			return tmp;
		}
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Utilisateur getUtilisateurFromJson(final Map map) {
		final Utilisateur utilisateur = new Utilisateur();

		utilisateur.setId(Long.valueOf(((Integer) map.get("id"))));
		utilisateur.setVersion((int) map.get("version"));
		utilisateur.setLogin((String) map.get(UtilisateurService.LOGIN));
		utilisateur.setPassword((String) map.get(UtilisateurService.MOT_DE_PASSE));
		utilisateur.setDroits(Droit.valueOf((String) map.get("droits")));

		return utilisateur;
	}
	
	/**
	 * Méthode d'update d'un utilisateur avec ou sans hashage.
	 * 
	 * @author frankybo57
	 * @since 1.0
	 * @param obj
	 * 		Utilisateur à créer.
	 * @param hash
	 * 		Si true alors hashage.
	 * @return
	 * 		Utilisateur mis à jour.
	 * 		
	 */
	@Override
	public Utilisateur update(final Utilisateur obj, final Object propriete, final String typePropriete, final boolean hash) throws UtilisateurException{

		try {
			// Test de nullité de l'id du nouvel utilisateur.
			if(obj.getId() == null) {
				throw new UtilisateurException(Constantes.UTILISATEUR_SANS_ID);
			}

			final Utilisateur temp = findOne(obj.getLogin(),obj.getPassword(),hash);
			if (temp == null) throw new UtilisateurException(Constantes.UTILISATEUR_NON_TROUVE);

			// Hashage du mot de passe si nécessaire.
			if(hash) {
				obj.setPassword(Verrou.cryptage(obj.getPassword()));
			}
			if (!temp.equals(obj))  throw new UtilisateurException(Constantes.UTILISATEUR_NON_CORRESPONDANT);
			
			switch(typePropriete) {
			case UtilisateurService.LOGIN:
				obj.setLogin((String) propriete);
				break;
			case UtilisateurService.MOT_DE_PASSE:
				if(hash)obj.setPassword(Verrou.cryptage((String) propriete));
				else obj.setPassword((String) propriete);
				break;
			case "droit":
				break;
			default:
				break;
			}
			
			

			// Tentative d'update de l'utilisateur.
			utiRepo.save(obj);

			obj.setPassword("");
		} catch(Exception e) {
			throw new UtilisateurException(messageNonMaJ(obj.getLogin()));
		}

		return obj;
	}
	
	public String messageNonMaJ(final String login) {
		return "L'utilisateur " + login + " n'a pas pu être mis à jour.";
	}
}
