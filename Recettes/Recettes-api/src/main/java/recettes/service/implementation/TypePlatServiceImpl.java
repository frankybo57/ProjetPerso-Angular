package recettes.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recettes.model.TypePlat;
import recettes.repository.TypePlatRepository;
import recettes.service.TypePlatService;

/**
 * Implémentation du service de gestion des TypePlat.
 * @author frankybo57
 *
 */
@Service
public class TypePlatServiceImpl implements TypePlatService {

	@Autowired
	private TypePlatRepository tpRepo;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TypePlat> findAll() {
		return tpRepo.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<TypePlat> findAllOrderByIdAsc() {
		return tpRepo.findAllOrderByIdAsc();
	}
}
