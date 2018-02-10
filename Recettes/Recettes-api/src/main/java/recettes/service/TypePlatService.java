package recettes.service;

import java.util.List;

import recettes.model.TypePlat;

/**
 * Service de gestion des TypePlat.
 * @author frankybo57
 *
 */
public interface TypePlatService {

	
	List<TypePlat> findAll();
	
	
	List<TypePlat> findAllOrderByIdAsc();
}
