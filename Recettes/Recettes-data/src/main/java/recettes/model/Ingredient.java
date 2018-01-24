package recettes.model;

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

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@SequenceGenerator(name="sequenceIngredient", sequenceName="SequenceIngredient")
public class Ingredient {
	
	@Id @GeneratedValue(generator="sequenceIngredient")
	@Column(name="id")
	@JsonView(Views.Common.class)
	private Long id;
	
	@Version
	@Column(name="version")
	@JsonView(Views.Common.class)
	private int version;
	
	@Column(name="label")
	@JsonView(Views.Common.class)
	private String label;
	
	@Column(name="utilisateur")
	@JsonView(Views.Common.class)
	private Integer utilisateur;
	
	@Column(name="visibilite")
	@JsonView(Views.Common.class)
	private Boolean prive;
	
	@Column(name="cout")
	@JsonView(Views.Common.class)
	private Short cout;
	
	@OneToMany(mappedBy="ingredient")
	@JsonView(Views.Ingredient.class)
	private List<RecetteIngredient> listeRecetteIngredient;
	
	@ManyToOne
	@JoinColumn(name="type_ingredient_id")
	@JsonView(Views.Common.class)
	private TypeIngredient typeIngredient;

	public Ingredient() {
		super();
	}

	public Ingredient(String label) {
		super();
		this.label = label;
	}

	public Ingredient(String label, TypeIngredient typeIngredient) {
		super();
		this.label = label;
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

	public Integer getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Integer utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Boolean getPrive() {
		return prive;
	}

	public void setPrive(Boolean prive) {
		this.prive = prive;
	}
	
	public boolean isVisible() {
		return this.prive.booleanValue();
	}

	public Short getCout() {
		return cout;
	}

	public void setCout(Short cout) {
		this.cout = cout;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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
