package recettes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import entites.Entite;

@Entity
@SequenceGenerator(name = "default_gen",sequenceName="SequenceRecetteIngredient")
@Table(name = "recette_ingredient", uniqueConstraints = @UniqueConstraint(columnNames = { "recette_id", "ingredient_id"}))
public class RecetteIngredient extends Entite{
	@ManyToOne
	@JoinColumn(name="recette_id")
	private Recette recette;
	
	@ManyToOne
	@JoinColumn(name="ingredient_id")
	private Ingredient ingredient;
	
	@Column(name="quantite")
	private String quantite;

	public RecetteIngredient() {
		super();
	}

	public Recette getRecette() {
		return recette;
	}

	public void setRecette(Recette recette) {
		this.recette = recette;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
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
