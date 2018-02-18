package noyau.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import constantes.Constantes;
import exception.ModuleException;
import noyau.model.Etat;
import noyau.model.Module;
import noyau.repository.ModuleRepository;
import noyau.service.ModuleService;


/**
 * {@inheritDoc}
 */
@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleRepository modRepo;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Module> findAll() {
		return modRepo.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Module> findAllOrderByIdAsc() {
		return modRepo.findAllOrderByIdAsc();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Module> findAllByEtat(final Etat etat) {
		return modRepo.findAllByEtat(etat);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Module findOne(final Long id) {
		return modRepo.findOne(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Module save(final Module module) throws ModuleException {
		if(module.getId()!=null) {
			throw new ModuleException(Constantes.NOUVEAU_MODULE_AVEC_ID);
		}
		return modRepo.save(module);
	}

	/**
	 * {@inheritDoc} 
	 */
	@Override
	public Module update(final Module module) throws ModuleException {
		if(module.getId()==null) {
			throw new ModuleException(Constantes.MODULE_SANS_ID);
		}
		return modRepo.save(module);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(final Long id) {
		modRepo.delete(id);
	}



}
