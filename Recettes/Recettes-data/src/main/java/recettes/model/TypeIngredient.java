package recettes.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonView;

import entites.EntitePossedee;
import jsonviews.Common;

@Entity
@SequenceGenerator(name = "default_gen",sequenceName="SequenceTypeIngredient")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "label"))
public class TypeIngredient extends EntitePossedee{
	@Column(name="niveau")
	@JsonView(Common.class)
	private Short niveau;
	
	@OneToMany(mappedBy="typeIngredient")
	@JsonView(Views.TypeIngredient.class)
	private List<Ingredient> listeIngredients;
	
	@OneToMany(mappedBy="typePere")
	@JsonView(Views.TypeIngredient.class)
	private List<TypeIngredient> typesFils;
	
	@ManyToOne
	@JoinColumn(name="type_pere_id")
	@JsonView(Views.TypeIngredient.class)
	private TypeIngredient typePere;
	
	public TypeIngredient() {
		super();
	}

	public TypeIngredient(String label) {
		super(label);
	}

	public TypeIngredient(String label, TypeIngredient typePere) {
		super(label);
		this.typePere = typePere;
	}

	public Short getNiveau() {
		return niveau;
	}

	public void setNiveau(Short niveau) {
		this.niveau = niveau;
	}

	public List<Ingredient> getListeIngredients() {
		return listeIngredients;
	}

	public void setListeIngredients(List<Ingredient> listeIngredients) {
		this.listeIngredients = listeIngredients;
	}

	public List<TypeIngredient> getTypesFils() {
		return typesFils;
	}

	public void setTypesFils(List<TypeIngredient> typesFils) {
		this.typesFils = typesFils;
	}

	public TypeIngredient getTypePere() {
		return typePere;
	}

	public void setTypePere(TypeIngredient typePere) {
		this.typePere = typePere;
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
