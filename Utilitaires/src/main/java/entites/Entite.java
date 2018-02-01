package entites;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import constantes.Constantes;
import jsonviews.Common;


/**
 * 
 * @author frankybo57
 *
 */
@MappedSuperclass
public abstract class Entite {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
	@Column(name="id")
	@JsonView(Common.class)
	protected Long id;
	
	@Version
	@Column(name="version", nullable=false)
	@JsonView(Common.class)
	protected int version;
	
	public Entite() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	/** 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = 1;
		result = Constantes.PRIME * result + ((id == null) ? 0 : id.hashCode());
		result = Constantes.PRIME * result + version;
		return result;
	}
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// Les deux références pointent sur le même objet.
		if (this == obj) return true;
				
		// L'objet comparé est nul ou a une classe différente
		if ((obj == null) || (getClass() != obj.getClass())) return false;
		
		Entite other = (Entite) obj;
		
		// Tests sur l'id
		if (id == null) {
			return (other.id == null);
		} 
		else if(!id.equals(other.id)) return false;
		
		// Tests sur la version
		return (version == other.version);
	}
}
