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
@SequenceGenerator(name = "default_gen",sequenceName="SequenceRecette")
public class Recette extends EntitePossedee implements PossedeLignes{	
	@ManyToOne
	@JoinColumn(name="type_plat_id")
	@JsonView(Common.class)
	private TypePlat typePlat;
	
	@Column(name="difficulte")
	@JsonView(Common.class)
	private Short difficulte;
	
	@Column(name="temps_preparation")
	@JsonView(Common.class)
	private String tempsPreparation;
	
	@Column(name="temps_repos")
	@JsonView(Common.class)
	private String tempsRepos;
	
	@Column(name="temps_cuisson")
	@JsonView(Common.class)
	private String tempsCuisson;
	
	@Column(name="nombre_couverts")
	@JsonView(Common.class)
	private Short nombreCouverts;
	
	@Column(name="cout")
	@JsonView(Common.class)
	private Short cout;
	
	@OneToMany(mappedBy="recette")
	@JsonView(Views.Recette.class)
	private List<RecetteIngredient> listeRecetteIngredient;
	
	@OneToMany(mappedBy="recette")
	@JsonView(Views.Recette.class)
	private List<LigneInstruction> instructions;
	
	@OneToMany(mappedBy="recette")
	@JsonView(Views.Recette.class)
	private List<LigneConseil> conseils;
	
	@Column(name="image")
	@JsonView(Views.Recette.class)
	private byte[] image;
	
	@Column(name="video")
	@JsonView(Views.Recette.class)
	private byte[] video;
	
	public Recette(){
		super();
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

	public String getTempsPreparation() {
		return tempsPreparation;
	}

	public void setTempsPreparation(String tempsPreparation) {
		this.tempsPreparation = tempsPreparation;
	}

	public String getTempsRepos() {
		return tempsRepos;
	}

	public void setTempsRepos(String tempsRepos) {
		this.tempsRepos = tempsRepos;
	}

	public String getTempsCuisson() {
		return tempsCuisson;
	}

	public void setTempsCuisson(String tempsCuisson) {
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

	public List<LigneInstruction> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<LigneInstruction> instructions) {
		this.instructions = instructions;
	}
	
	/**
	 * Méthode d'ajout d'une LigneInstruction à la List des LigneInstruction de la Recette.
	 * 
	 * @param ligneInstruction LigneInstruction à ajouter.
	 */
	public void ajouterLigneInstruction(final LigneInstruction ligneInstruction) {
		this.instructions.add(ligneInstruction);
	}

	public List<LigneConseil> getConseils() {
		return conseils;
	}

	public void setConseils(List<LigneConseil> conseils) {
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
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
