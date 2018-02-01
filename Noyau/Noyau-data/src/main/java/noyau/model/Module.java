package noyau.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import constantes.Constantes;
import entites.Entite;
import jsonviews.Common;

/**
 * @author Francois 2
 * @version 0.0.1-Snapshot
 */
@Entity
@Table(name = "modules")
@SequenceGenerator(name = "default_gen", sequenceName = "SequenceModule")
public class Module extends Entite {
	@JsonView(Common.class)
	@Column(name = "nom", nullable=false)
	private String nom;
	@JsonView(Common.class)
	@Column(name="header")
	private String header;
	@JsonView(Views.Module.class)
	@Column(name = "etat", nullable=false)
	private Etat etat;
	
	public Module(){
		
	}
	
	public Module(String nom){
		this.nom = nom;
		this.etat = Etat.INACTIF;
	}

	public Module(String nom, String header, Etat etat) {
		super();
		this.nom = nom;
		this.header = header;
		this.etat = etat;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	/**
	 * @return the etat
	 */
	public Etat getEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = Constantes.PRIME * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) return false;
		Module other = (Module) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
}
