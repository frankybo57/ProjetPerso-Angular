package constantes;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultMatcher;

/**
 * Constantes utilisées.
 * 
 * @author frankybo57
 * @since 1.0
 *
 */
public abstract class Constantes {
	/**
	 * Constante utiliséee dans le calcul des hash.
	 */
	public static final int PRIME = 31;
	
	// Constantes de texte Utilisateur
	/**
	 * Constante de texte utilisée lorsqu'un Utilisateur donné n'est pas trouvé en base.
	 */
	public static final String UTILISATEUR_NON_TROUVE = "Utilisateur non trouvé.";
	/**
	 * Constante de texte utilisée lorsqu'un Utilisateur qui doit être sauvegardé en base a déjà un identifiant.
	 */
	public static final String NOUVEL_UTILISATEUR_AVEC_ID ="Le nouvel utilisateur ne devrait pas avoir d'id.";
	/**
	 * Constante de texte utilisée lorsqu'un Utilisateur qui doit être mis à jour en base n'a pas d'identifiant.
	 */
	public static final String UTILISATEUR_SANS_ID ="L'utilisateur devrait avoir un id.";
	public static final String UTILISATEUR_NON_CORRESPONDANT = "Erreur de correspondance.";
	
	// Constantes de texte Recette
	/**
	 * Constante de texte utilisée lorsqu'une Recette donnée n'est pas trouvée en base.
	 */
	public static final String RECETTE_NON_TROUVEE = "Recette non trouvée.";
	/**
	 * Constante de texte utilisée lorsqu'une Recette qui doit être sauvegardée en base a déjà un identifiant.
	 */
	public static final String NOUVELLE_RECETTE_AVEC_ID ="Problème : la nouvelle recette ne devrait pas avoir d'id.";
	/**
	 * Constante de texte utilisée lorsqu'une Recette qui doit être mise à jour en base n'a pas d'identifiant.
	 */
	public static final String RECETTE_SANS_ID ="Problème : la recette devrait avoir un id.";
	
	// Constantes de texte Ingrédient
	/**
	 * Constante de texte utilisée lorsqu'un Ingredient donné n'est pas trouvé en base.
	 */
	public static final String INGREDIENT_NON_TROUVE = "Ingrédient non trouvé.";
	/**
	 * Constante de texte utilisée lorsqu'un Ingredient qui doit être sauvegardé en base a déjà un identifiant.
	 */
	public static final String NOUVEL_INGREDIENT_AVEC_ID ="Problème : le nouvel ingrédient ne devrait pas avoir d'id.";
	/**
	 * Constante de texte utilisée lorsqu'un Ingredient qui doit être mis à jour en base n'a pas d'identifiant.
	 */
	public static final String INGREDIENT_SANS_ID ="Problème : l'ingrédient devrait avoir un id.";
	
	// Constantes de TypePlat
	/**
	 * Constante de texte utilisée lorsqu'un TypePlat donné n'est pas trouvé en base.
	 */
	public static final String TYPEPLAT_NON_TROUVE = "TypePlat non trouvé.";
	/**
	 * Constante de texte utilisée lorsqu'un TypePlat qui doit être sauvegardé en base a déjà un identifiant.
	 */
	public static final String NOUVEAU_TYPEPLAT_AVEC_ID ="Problème : le nouveau typePlat ne devrait pas avoir d'id.";
	/**
	 * Constante de texte utilisée lorsqu'un TypePlat qui doit être mis à jour en base n'a pas d'identifiant.
	 */
	public static final String TYPEPLAT_SANS_ID ="Problème : le typePlat devrait avoir un id.";
	
	// Constantes de Module
	/**
	 * Constante de texte utilisée lorsqu'un Module donné n'est pas trouvé en base.
	 */
	public static final String MODULE_NON_TROUVE = "Module non trouvé.";
	/**
	 * Constante de texte utilisée lorsqu'un Module qui doit être sauvegardé en base a déjà un identifiant.
	 */
	public static final String NOUVEAU_MODULE_AVEC_ID ="Problème : le nouveau module ne devrait pas avoir d'id.";
	/**
	 * Constante de texte utilisée lorsqu'un Module qui doit être mis à jour en base n'a pas d'identifiant.
	 */
	public static final String MODULE_SANS_ID ="Problème : le module devrait avoir un id.";

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
