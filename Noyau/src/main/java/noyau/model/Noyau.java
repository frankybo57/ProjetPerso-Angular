package noyau.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import noyau.repositories.ModuleRepository;
import noyau.repositories.UtilisateurRepository;

/**
 * @author Francois 2
 * @version 0.0.1-Snapshot
 */
public class Noyau {
	private Noyau instance = null;
	private ArrayList<Utilisateur> listeUtilisateurs;
	private ArrayList<Module> listeModules;
	private ArrayList<Module> listeModulesActifs;
	
	@Autowired
	private UtilisateurRepository utiRepo;
	@Autowired
	private ModuleRepository modRepo;
	
	private Noyau(){
		this.listeModules = (ArrayList<Module>) modRepo.findAll();
		this.listeModulesActifs = (ArrayList<Module>) modRepo.findAllByEtat(Etat.Actif);
		
		this.listeUtilisateurs = (ArrayList<Utilisateur>) utiRepo.findAll();
	}
	
	public Noyau startNoyau(){
		if(this.instance == null) this.instance = new Noyau();
		return this.instance;
	}
	
	public void stopNoyau(){
		modRepo.save(this.listeModules);
		utiRepo.save(this.listeUtilisateurs);
	}
}
