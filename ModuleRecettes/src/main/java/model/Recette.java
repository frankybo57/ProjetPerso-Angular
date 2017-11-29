package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
@SequenceGenerator(name="sequenceRecette",sequenceName="SequenceRecette")
public class Recette {
	@Id @GeneratedValue(generator="sequenceRecette")
	@Column(name="id")
	private Integer id;
	
	@Version
	@Column(name="version")
	private int version;
	
	@Column(name="label")
	private String label;
	
	@Column(name="typePlat")
	private TypePlat typePlat;
	
	@Column(name="difficulte")
	private Short difficulte;
	
	@Column(name="temps_preparation")
	private Integer tempsPreparation;
	
	@Column(name="temps_cuisson")
	private Integer tempsCuisson;
	
	@Column(name="nombre=couverts")
	private Short nombreCouverts;
	
	@Column(name="cout")
	private Short cout;
	
	@OneToMany(mappedBy="recette")
	private List<RecetteIngredient> listeRecetteIngredient;
	
	@Column(name="instructions")
	private String instructions;
	
	@Column(name="conseils")
	private String conseils;
	
	@Column(name="image")
	private byte[] image;
	
	@Column(name="video")
	private byte[] video;
	
	public Recette(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public TypePlat getTypePlat() {
		return typePlat;
	}

	public void setTypePlat(TypePlat typePlat) {
		this.typePlat = typePlat;
	}

	public Short getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(Short difficulte) {
		this.difficulte = difficulte;
	}

	public Integer getTempsPreparation() {
		return tempsPreparation;
	}

	public void setTempsPreparation(Integer tempsPreparation) {
		this.tempsPreparation = tempsPreparation;
	}

	public Integer getTempsCuisson() {
		return tempsCuisson;
	}

	public void setTempsCuisson(Integer tempsCuisson) {
		this.tempsCuisson = tempsCuisson;
	}

	public Short getNombreCouverts() {
		return nombreCouverts;
	}

	public void setNombreCouverts(Short nombreCouverts) {
		this.nombreCouverts = nombreCouverts;
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

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
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

	public byte[] getVideo() {
		return video;
	}

	public void setVideo(byte[] video) {
		this.video = video;
	}
}
