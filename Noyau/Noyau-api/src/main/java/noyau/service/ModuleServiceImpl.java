package noyau.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noyau.model.Etat;
import noyau.model.Module;
import noyau.repository.ModuleRepository;

@Service
public class ModuleServiceImpl implements ModuleService {
	
	@Autowired
	private ModuleRepository modRepo;

	@SuppressWarnings("rawtypes")
	@Override
	public List findAll() {
		return modRepo.findAll();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findAllOrderByIdAsc() {
		return modRepo.findAllOrderByIdAsc();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findAllByEtat(Etat etat) {
		return modRepo.findAllByEtat(etat);
	}

	@Override
	public Module findOne(Long id) {
		return modRepo.findOne(id);
	}

	@Override
	public Module save(Module module) {
		return modRepo.save(module);
	}

	@Override
	public Module update(Module module) {
		return modRepo.save(module);
	}

	@Override
	public void delete(Long id) {
		modRepo.delete(id);
	}

	

}
