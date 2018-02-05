package noyau.service;

import java.util.List;

import noyau.model.Etat;
import noyau.model.Module;

public interface ModuleService {
	
	@SuppressWarnings("rawtypes")
	public List findAll();
	
	@SuppressWarnings("rawtypes")
	public List findAllOrderByIdAsc();
	
	@SuppressWarnings("rawtypes")
	public List findAllByEtat(Etat etat);
	
	public Module findOne(Long id);
	
	public Module save(Module module);
	
	public Module update(Module module);
	
	public void delete(Long id);
}
