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
public class Constantes {
	public static final int PRIME = 31;
	
	public static final String UTILISATEUR_NON_TROUVE = "Utilisateur non trouvé.";
	public static final String NOUVEL_UTILISATEUR_AVEC_ID ="Le nouvel utilisateur ne devrait pas avoir d'id.";
	public static final String UTILISATEUR_SANS_ID ="L'utilisateur devrait avoir un id.";
	public static final String UTILISATEUR_NON_CORRESPONDANT = "Erreur de correspondance.";
	
	public static final String RECETTE_NON_TROUVEE = "Recette non trouvée.";
	public static final String NOUVELLE_RECETTE_AVEC_ID ="Problème : la nouvelle recette ne devrait pas avoir d'id.";
	public static final String RECETTE_SANS_ID ="Problème : la recette devrait avoir un id.";
	
	public static final String INGREDIENT_NON_TROUVE = "Ingrédient non trouvé.";
	public static final String NOUVEL_INGREDIENT_AVEC_ID ="Problème : le nouvel ingrédient ne devrait pas avoir d'id.";
	public static final String INGREDIENT_SANS_ID ="Problème : l'ingrédient devrait avoir un id.";
	
	public static final String TYPEPLAT_NON_TROUVE = "TypePlat non trouvé.";
	public static final String NOUVEAU_TYPEPLAT_AVEC_ID ="Problème : le nouveau typePlat ne devrait pas avoir d'id.";
	public static final String TYPEPLAT_SANS_ID ="Problème : le typePlat devrait avoir un id.";
	
	public static final String MODULE_NON_TROUVE = "Module non trouvé.";
	public static final String NOUVEAU_MODULE_AVEC_ID ="Problème : le nouveau module ne devrait pas avoir d'id.";
	public static final String MODULE_SANS_ID ="Problème : le module devrait avoir un id.";

	
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
	
	private Constantes() {
		
	}
	
	
}
