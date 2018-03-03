package recettes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonView;

import constantes.Constantes;
import entites.Entite;

@Entity
@SequenceGenerator(name = "default_gen",sequenceName="SequenceLigneConseil")
public class LigneConseil extends Entite implements Balayable{
	@Column(name="conseil")
	@JsonView(Views.LigneConseil.class)
	private String conseil;
	
	@ManyToOne
	@JoinColumn(name="recette_id")
	private Recette recette;
	
	@ManyToOne
	@JoinColumn(name="ingredient_id")
	private Ingredient ingredient;
	
	public LigneConseil() {

	}
	
	public LigneConseil(PossedeLignes entite) {
		setEntite(entite);
	}

	public LigneConseil(String instruction) {
		super();
		this.conseil = instruction;
	}

	public String getConseil() {
		return conseil;
	}

	public void setConseil(String instruction) {
		this.conseil = instruction;
	}

	protected Recette getRecette() {
		return recette;
	}

	protected void setRecette(Recette entite) {
		this.recette = entite;
	}
	
	protected Ingredient getIngredient() {
		return ingredient;
	}

	protected void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	
	public void setEntite(PossedeLignes entite) {
		if(entite instanceof Ingredient) {
			this.ingredient = (Ingredient) entite;
		}
		else if(entite instanceof Recette) {
			this.recette = (Recette) entite;
		} 
	}
	
	public PossedeLignes getEntite() {
		if(this.ingredient != null) return ingredient;
		if(this.recette != null) return recette;
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		LigneConseil ligneConseil = (LigneConseil) obj;
		if(this.conseil == null) {
			return ligneConseil.getConseil() == null;
		}
		else {
			return this.conseil.equals(ligneConseil.getConseil());
		}
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = Constantes.PRIME * result + ((recette == null) ? 0 : recette.hashCode());
		result = Constantes.PRIME * result + ((conseil == null) ? 0 : conseil.hashCode());
		return result;
	}

}
