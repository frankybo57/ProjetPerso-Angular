package recettes.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonView;

import entites.EntitePossedee;
import jsonviews.Common;

@Entity
@SequenceGenerator(name = "default_gen",sequenceName="SequenceTypePlat")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "label"),@UniqueConstraint(columnNames = "ancre")})
public class TypePlat extends EntitePossedee{
	@Column(name="ancre")
	@JsonView(Common.class)
	private String ancre;
	
	@OneToMany(mappedBy="typePlat")
	@JsonView(Views.TypePlat.class)
	private List<Recette> listeRecettes;
	
	public TypePlat() {
		super();
	}

	public TypePlat(String label, String ancre) {
		super(label);
		this.ancre = ancre;
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
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
}
