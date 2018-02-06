package noyau.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noyau.model.Etat;
import noyau.model.Module;
import noyau.repository.ModuleRepository;


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
	@SuppressWarnings("rawtypes")
	@Override
	public List findAll() {
		return modRepo.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List findAllOrderByIdAsc() {
		return modRepo.findAllOrderByIdAsc();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List findAllByEtat(final Etat etat) {
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
	public Module save(final Module module) {
		return modRepo.save(module);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Module update(final Module module) {
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
