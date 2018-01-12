package noyau.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author Francois 2
 * @version 0.0.1-Snapshot
 */
@Entity
@Table(name = "modules")
@SequenceGenerator(name = "sequenceModule", sequenceName = "SequenceModule")
public class Module {
	@JsonView(Views.Common.class)
	@Id @GeneratedValue(generator = "sequenceModule")
	private Integer id;
	@JsonView(Views.Common.class)
	@Version
	private int version;
	@JsonView(Views.Common.class)
	@Column(name = "nom")
	private String nom;
	@JsonView(Views.Common.class)
	@Column(name="header")
	private String header;
	@JsonView(Views.Module.class)
	@Column(name = "etat")
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
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
}
