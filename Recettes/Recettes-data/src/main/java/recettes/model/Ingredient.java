package recettes.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonView;

import entites.EntitePossedee;
import jsonviews.Common;

@Entity
@SequenceGenerator(name = "default_gen", sequenceName="SequenceIngredient")
public class Ingredient extends EntitePossedee{
	@Column(name="cout")
	@JsonView(Common.class)
	private Short cout;
	
	@OneToMany(mappedBy="ingredient")
	@JsonView(Views.Ingredient.class)
	private List<RecetteIngredient> listeRecetteIngredient;
	
	@ManyToOne
	@JoinColumn(name="type_ingredient_id")
	@JsonView(Common.class)
	private TypeIngredient typeIngredient;
	
	@Column(name="conseils")
	@JsonView(Common.class)
	private String conseils;
	
	@Column(name="image")
	@JsonView(Views.Ingredient.class)
	private byte[] image;

	public Ingredient() {
		super();
	}

	public Ingredient(String label) {
		super(label);
	}

	public Ingredient(String label, TypeIngredient typeIngredient) {
		super(label);
		this.typeIngredient = typeIngredient;
	}

	public Short getCout() {
		return cout;
	}

	public void setCout(Short cout) {
		this.cout = cout;
	}

	public List<RecetteIngredient> getListeRecetteIngredient() {
		return listeRecetteIngredient;
	}

	public void setListeRecetteIngredient(List<RecetteIngredient> listeRecetteIngredient) {
		this.listeRecetteIngredient = listeRecetteIngredient;
	}

	public TypeIngredient getTypeIngredient() {
		return typeIngredient;
	}

	public void setTypeIngredient(TypeIngredient typeIngredient) {
		this.typeIngredient = typeIngredient;
	}

	public String getConseils() {
		return conseils;
	}

	public void setConseils(String conseils) {
		this.conseils = conseils;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
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
