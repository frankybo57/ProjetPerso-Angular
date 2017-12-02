package modulerecettes.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
@SequenceGenerator(name="sequenceIngredient", sequenceName="SequenceIngredient")
public class Ingredient {
	
	@Id @GeneratedValue(generator="sequenceIngredient")
	@Column(name="id")
	private Long id;
	
	@Version
	@Column(name="version")
	private int version;
	
	@Column(name="label")
	private String label;
	
	@Column(name="quantite")
	private String quantite;
	
	@OneToMany(mappedBy="ingredient")
	private List<RecetteIngredient> listeRecetteIngredient;
	
	@ManyToOne
	@JoinColumn(name="type_ingredient_id")
	private TypeIngredient typeIngredient;

	public Ingredient() {
		super();
	}

	public Ingredient(String label, String quantite) {
		super();
		this.label = label;
		this.quantite = quantite;
	}

	public Ingredient(String label, String quantite, TypeIngredient typeIngredient) {
		super();
		this.label = label;
		this.quantite = quantite;
		this.typeIngredient = typeIngredient;
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
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
	
	
}
