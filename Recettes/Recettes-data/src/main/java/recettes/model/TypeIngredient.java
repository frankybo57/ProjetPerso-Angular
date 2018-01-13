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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@SequenceGenerator(name="sequenceTypeIngredient",sequenceName="SequenceTypeIngredient")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "label"))
public class TypeIngredient {

	@Id @GeneratedValue(generator="sequenceTypeIngredient")
	@Column(name="id")
	@JsonView(Views.Common.class)
	private Short id;
	
	@Version
	@Column(name="version")
	@JsonView(Views.Common.class)
	private int version;
	
	@Column(name="label")
	@JsonView(Views.Common.class)
	private String label;
	
	@OneToMany(mappedBy="typeIngredient")
	@JsonView(Views.TypeIngredient.class)
	private List<Ingredient> listeIngredients;
	
	@OneToMany(mappedBy="typePere")
	private List<TypeIngredient> typesFils;
	
	@ManyToOne
	@JoinColumn(name="type_fils_id")
	private TypeIngredient typePere;
	
	public TypeIngredient() {
		super();
	}

	public TypeIngredient(String label) {
		super();
		this.label = label;
	}

	public TypeIngredient(String label, TypeIngredient typePere) {
		super();
		this.label = label;
		this.typePere = typePere;
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
	
	
}
