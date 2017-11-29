package modulerecettes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@SequenceGenerator(name="sequenceRecetteIngredient",sequenceName="SequenceRecetteIngredient")
@Table(name = "module_classroom", uniqueConstraints = @UniqueConstraint(columnNames = { "recette_id", "ingredient_id"}))
public class RecetteIngredient {
	
	@Id @GeneratedValue(generator="sequenceRecetteIngredient")
	@Column(name="id")
	private Long id;
	
	@Version
	@Column(name="version")
	private int version;
	
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
}
