package noyau.service.implementation;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import constantes.Constantes;
import exception.UtilisateurException;
import noyau.model.Droit;
import noyau.model.Utilisateur;
import noyau.repository.UtilisateurRepository;
import noyau.service.HashService;
import noyau.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{
	private static final Logger LOGGER = LogManager.getLogger(UtilisateurServiceImpl.class);
	@Autowired
	private UtilisateurRepository utiRepo;
	@Autowired
	private HashService hService;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Utilisateur createOne(Utilisateur obj, final boolean hash) throws UtilisateurException {
		String message;

		// Test d'unicité du login.
		if (utiRepo.findByLogin(obj.getLogin())!=null) {
			message = "Un compte avec le nom d'utilisateur \""+ obj.getLogin() + "\" existe déjà.";
			if(LOGGER.isErrorEnabled()) {
	    		LOGGER.error(message);
	    	}
			throw new UtilisateurException(message);
		}

		// Test de nullité de l'id du nouvel utilisateur.
		if (obj.getId() != null) {
			if(LOGGER.isErrorEnabled()) {
	    		LOGGER.error(Constantes.NOUVEL_UTILISATEUR_AVEC_ID);
	    	}
			throw new UtilisateurException(Constantes.NOUVEL_UTILISATEUR_AVEC_ID);
		}

		// Hashage du mot de passe si nécessaire.
		if(hash) {
			obj.setPassword(hService.cryptage(obj.getPassword()));
		}

		obj.setDroits(Droit.UTILISATEUR);
		obj = utiRepo.save(obj);
		obj.setPassword("");

		return obj;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Utilisateur> findAll() {
		return utiRepo.findAll();
	}
	
	/**
	 * 	{@inheritDoc}
	 */
	@Override
	public Utilisateur findOne(final String login, final String password, final boolean hash) throws UtilisateurException{
		Utilisateur tmp;
		if(hash) {
			tmp = utiRepo.findOneByLoginAndByPassword(login,hService.cryptage(password));
		}
		else {
			tmp = utiRepo.findOneByLoginAndByPassword(login,password);
		}
		if (tmp == null) {
			if(LOGGER.isErrorEnabled()) {
	    		LOGGER.error(Constantes.UTILISATEUR_NON_TROUVE);
	    	}
			throw new UtilisateurException(Constantes.UTILISATEUR_NON_TROUVE);
		} else {
			return tmp;
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Utilisateur getUtilisateurFromJson(final Map map) {
		final Utilisateur utilisateur = new Utilisateur();

		utilisateur.setId(Long.valueOf((Integer)map.get("id")));
		utilisateur.setVersion((int)map.get("version"));
		utilisateur.setLogin((String) map.get(Constantes.LOGIN));
		utilisateur.setPassword((String) map.get(Constantes.MOT_DE_PASSE));
		utilisateur.setDroits(Droit.valueOf((String) map.get("droits")));

		return utilisateur;
	}
	
	/**
	 * 	{@inheritDoc}	
	 */
	@Override
	public Utilisateur update(final Utilisateur utilisateur, final Object propriete, final String typePropriete, final boolean hash) throws UtilisateurException{
		final Utilisateur objMaJ;
		try {
			if(utilisateur.getId() == null) {
				if(LOGGER.isErrorEnabled()) {
		    		LOGGER.error(Constantes.UTILISATEUR_SANS_ID);
		    	}
				throw new UtilisateurException(Constantes.UTILISATEUR_SANS_ID);
			}

			comparaisonUtilisateur(utilisateur, hash);
			
			reconstructionObjetAvantMaj(utilisateur, propriete, typePropriete, hash);
			
			objMaJ = utiRepo.save(utilisateur);

			objMaJ.setPassword("");
		} catch(Exception e) {
			if(LOGGER.isDebugEnabled()) {
	    		LOGGER.debug(messageNonMaJ(utilisateur.getLogin()));
	    	}
			throw new UtilisateurException(messageNonMaJ(utilisateur.getLogin()));
		}
		return objMaJ;
	}

	/**
	 * @param utilisateur l'Utilisateur à chercheren base.
	 * @param hash
	 * @throws UtilisateurException si l'Utilisateur n'existe pas en base ou s'il ne correspond pas à l'Utilisateur trouvé.
	 */
	private void comparaisonUtilisateur(final Utilisateur utilisateur, final boolean hash) throws UtilisateurException {
		final Utilisateur temp = findOne(utilisateur.getLogin(),utilisateur.getPassword(),hash);
		if (temp == null) {
			if(LOGGER.isErrorEnabled()) {
				LOGGER.error(Constantes.UTILISATEUR_NON_TROUVE);
			}
			throw new UtilisateurException(Constantes.UTILISATEUR_NON_TROUVE);
		}
		if(hash) {
			utilisateur.setPassword(hService.cryptage(utilisateur.getPassword()));
		}
		if (!temp.equals(utilisateur)) {
			if(LOGGER.isErrorEnabled()) {
				LOGGER.error(Constantes.UTILISATEUR_NON_CORRESPONDANT);
			}
			throw new UtilisateurException(Constantes.UTILISATEUR_NON_CORRESPONDANT);
		}
	}

	/**
	 * Reconstruit un Utilisateur avant de la mettre à jour.
	 * 
	 * @param utilisateur l'Utilisateur à reconstruire.
	 * @param propriete la valeur de l'attribut considéré.
	 * @param typePropriete l'attribut considéré.
	 * @param hash
	 */
	private void reconstructionObjetAvantMaj(final Utilisateur utilisateur, final Object propriete, final String typePropriete,
			final boolean hash) {
		switch(typePropriete) {
		case Constantes.LOGIN:
			utilisateur.setLogin((String) propriete);
			break;
		case Constantes.MOT_DE_PASSE:
			if(hash)utilisateur.setPassword(hService.cryptage((String) propriete));
			else utilisateur.setPassword((String) propriete);
			break;
		case "droit":
			break;
		default:
			break;
		}
	}
	
	/**
	 * Crée un message à logger en cas de non mise à jour.
	 * @param login Login de l'utilisateur n'ayant pas pu être mis à jour.
	 * @return message à logger.
	 */
	public String messageNonMaJ(final String login) {
		return "L'utilisateur " + login + " n'a pas pu être mis à jour.";
	}
}
