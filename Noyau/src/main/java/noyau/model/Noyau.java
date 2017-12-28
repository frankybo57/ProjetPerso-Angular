package noyau.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import noyau.repositories.ModuleRepository;
import noyau.repositories.UtilisateurRepository;

/**
 * @author Francois 2
 * @version 0.0.1-Snapshot
 */
public class Noyau {

	private Noyau instance;
	private ArrayList<Utilisateur> listeUtilisateurs;
	private ArrayList<Module> listeModules;
	private ArrayList<Module> listeModulesActifs;
	
	@Autowired
	private UtilisateurRepository utiRepo;
	@Autowired
	private ModuleRepository modRepo;
	
	private Noyau(){
		this.listeModules = (ArrayList<Module>) modRepo.findAll();
		this.listeModulesActifs = (ArrayList<Module>) modRepo.findAllByEtat(Etat.ACTIF);
		
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

	public List<Utilisateur> getListeUtilisateurs() {
		return listeUtilisateurs;
	}

	public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
		this.listeUtilisateurs = (ArrayList<Utilisateur>) listeUtilisateurs;
	}

	public List<Module> getListeModules() {
		return listeModules;
	}

	public void setListeModules(List<Module> listeModules) {
		this.listeModules = (ArrayList<Module>) listeModules;
	}

	public List<Module> getListeModulesActifs() {
		return listeModulesActifs;
	}

	public void setListeModulesActifs(List<Module> listeModulesActifs) {
		this.listeModulesActifs = (ArrayList<Module>) listeModulesActifs;
	}
	
	
}
