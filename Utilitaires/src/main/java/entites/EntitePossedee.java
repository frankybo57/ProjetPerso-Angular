package entites;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonView;

import constantes.Constantes;
import jsonviews.Common;


/**
 * 
 * @author frankybo57
 *
 */
@MappedSuperclass
public abstract class EntitePossedee extends Entite {
	@Column(name="label")
	@JsonView(Common.class)
	private String label;
	
	@Column(name="utilisateur")
	@JsonView(Common.class)
	private Integer utilisateur;
	
	@Column(name="visibilite")
	@JsonView(Common.class)
	private Boolean prive;
	
	public EntitePossedee() {
		super();
	}
	
	public EntitePossedee(String label) {
		super();
		this.label = label;
	}
	
	public EntitePossedee(String label, Integer utilisateur) {
		super();
		this.label = label;
		this.utilisateur = utilisateur;
	}
	
	public EntitePossedee(String label, Integer utilisateur, Boolean prive) {
		super();
		this.label = label;
		this.utilisateur = utilisateur;
		this.prive = prive;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Integer utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Boolean getPrive() {
		return prive;
	}

	public void setPrive(Boolean prive) {
		this.prive = prive;
	}
	
	public boolean isVisible() {
		return this.prive.booleanValue();
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		return (Constantes.PRIME * result + ((label == null) ? 0 : label.hashCode()));
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		EntitePossedee other = (EntitePossedee) obj;
		if(this.label == null) {
			return other.label == null;
		} else return label.equals(other.label);	
	}
}
