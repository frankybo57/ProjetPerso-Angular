package modulerecettes.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
@SequenceGenerator(name="sequenceTypePlat",sequenceName="SequenceTypePlat")
public class TypePlat {

	@Id @GeneratedValue(generator="sequenceTypePlat")
	@Column(name="id)")
	private Short id;
	
	@Version
	@Column(name="version")
	private int version;
	
	@Column(name="label")
	private String label;
	
	@Column(name="ancre")
	private String ancre;
	
	@OneToMany(mappedBy="type_plat")
	private List<Recette> listeRecettes;
	
	public TypePlat() {
		super();
	}

	public TypePlat(String label, String ancre) {
		super();
		this.label = label;
		this.ancre = ancre;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getAncre() {
		return ancre;
	}

	public void setAncre(String ancre) {
		this.ancre = ancre;
	}

	public List<Recette> getListeRecettes() {
		return listeRecettes;
	}

	public void setListeRecettes(List<Recette> listeRecettes) {
		this.listeRecettes = listeRecettes;
	}
	
	
}
