package constantes;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultMatcher;

/**
 * Constantes utilis�es.
 * 
 * @author frankybo57
 * @since 1.0
 *
 */
public abstract class Constantes {
	/**
	 * Constante utilis�ee dans le calcul des hash.
	 */
	public static final int PRIME = 31;
	
	// Constantes de texte Utilisateur
	/**
	 * Constante de texte utilis�e lorsqu'un Utilisateur donn� n'est pas trouv� en base.
	 */
	public static final String UTILISATEUR_NON_TROUVE = "Utilisateur non trouv�.";
	/**
	 * Constante de texte utilis�e lorsqu'un Utilisateur qui doit �tre sauvegard� en base a d�j� un identifiant.
	 */
	public static final String NOUVEL_UTILISATEUR_AVEC_ID ="Le nouvel utilisateur ne devrait pas avoir d'id.";
	/**
	 * Constante de texte utilis�e lorsqu'un Utilisateur qui doit �tre mis � jour en base n'a pas d'identifiant.
	 */
	public static final String UTILISATEUR_SANS_ID ="L'utilisateur devrait avoir un id.";
	public static final String UTILISATEUR_NON_CORRESPONDANT = "Erreur de correspondance.";
	
	// Constantes de texte Recette
	/**
	 * Constante de texte utilis�e lorsqu'une Recette donn�e n'est pas trouv�e en base.
	 */
	public static final String RECETTE_NON_TROUVEE = "Recette non trouv�e.";
	/**
	 * Constante de texte utilis�e lorsqu'une Recette qui doit �tre sauvegard�e en base a d�j� un identifiant.
	 */
	public static final String NOUVELLE_RECETTE_AVEC_ID ="Probl�me : la nouvelle recette ne devrait pas avoir d'id.";
	/**
	 * Constante de texte utilis�e lorsqu'une Recette qui doit �tre mise � jour en base n'a pas d'identifiant.
	 */
	public static final String RECETTE_SANS_ID ="Probl�me : la recette devrait avoir un id.";
	
	// Constantes de texte Ingr�dient
	/**
	 * Constante de texte utilis�e lorsqu'un Ingredient donn� n'est pas trouv� en base.
	 */
	public static final String INGREDIENT_NON_TROUVE = "Ingr�dient non trouv�.";
	/**
	 * Constante de texte utilis�e lorsqu'un Ingredient qui doit �tre sauvegard� en base a d�j� un identifiant.
	 */
	public static final String NOUVEL_INGREDIENT_AVEC_ID ="Probl�me : le nouvel ingr�dient ne devrait pas avoir d'id.";
	/**
	 * Constante de texte utilis�e lorsqu'un Ingredient qui doit �tre mis � jour en base n'a pas d'identifiant.
	 */
	public static final String INGREDIENT_SANS_ID ="Probl�me : l'ingr�dient devrait avoir un id.";
	
	// Constantes de TypePlat
	/**
	 * Constante de texte utilis�e lorsqu'un TypePlat donn� n'est pas trouv� en base.
	 */
	public static final String TYPEPLAT_NON_TROUVE = "TypePlat non trouv�.";
	/**
	 * Constante de texte utilis�e lorsqu'un TypePlat qui doit �tre sauvegard� en base a d�j� un identifiant.
	 */
	public static final String NOUVEAU_TYPEPLAT_AVEC_ID ="Probl�me : le nouveau typePlat ne devrait pas avoir d'id.";
	/**
	 * Constante de texte utilis�e lorsqu'un TypePlat qui doit �tre mis � jour en base n'a pas d'identifiant.
	 */
	public static final String TYPEPLAT_SANS_ID ="Probl�me : le typePlat devrait avoir un id.";
	
	// Constantes de Module
	/**
	 * Constante de texte utilis�e lorsqu'un Module donn� n'est pas trouv� en base.
	 */
	public static final String MODULE_NON_TROUVE = "Module non trouv�.";
	/**
	 * Constante de texte utilis�e lorsqu'un Module qui doit �tre sauvegard� en base a d�j� un identifiant.
	 */
	public static final String NOUVEAU_MODULE_AVEC_ID ="Probl�me : le nouveau module ne devrait pas avoir d'id.";
	/**
	 * Constante de texte utilis�e lorsqu'un Module qui doit �tre mis � jour en base n'a pas d'identifiant.
	 */
	public static final String MODULE_SANS_ID ="Probl�me : le module devrait avoir un id.";

	// Constantes de test de ControllerRest
	public static final ResultMatcher INTERNAL_SERVER_ERROR = status().isInternalServerError();
	public static final ResultMatcher BAD_REQUEST = status().isBadRequest();
	public static final ResultMatcher NOT_FOUND = status().isNotFound();
	public static final ResultMatcher OK = status().isOk();
	public static final ResultMatcher CREATED = status().isCreated();
	public static final ResultMatcher JSON = content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
	public static final ResultMatcher NO_CONTENT = status().isNoContent();

	public static final String UTILISATEUR = "utilisateur";

	public static final String LOGIN = "login";

	public static final String MOT_DE_PASSE = "password";
	
	private Constantes() {}
}
