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

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@SequenceGenerator(name="sequenceRecette",sequenceName="SequenceRecette")
public class Recette {
	@Id @GeneratedValue(generator="sequenceRecette")
	@Column(name="id")
	@JsonView(Views.Common.class)
	private Integer id;
	
	@Version
	@Column(name="version")
	@JsonView(Views.Common.class)
	private int version;
	
	@Column(name="label")
	@JsonView(Views.Common.class)
	private String label;
	
	@ManyToOne
	@JoinColumn(name="type_plat_id")
	@JsonView(Views.Common.class)
	private TypePlat typePlat;
	
	@Column(name="difficulte")
	@JsonView(Views.Common.class)
	private Short difficulte;
	
	@Column(name="temps_preparation")
	@JsonView(Views.Common.class)
	private String tempsPreparation;
	
	@Column(name="temps_repos")
	@JsonView(Views.Common.class)
	private String tempsRepos;
	
	@Column(name="temps_cuisson")
	@JsonView(Views.Common.class)
	private String tempsCuisson;
	
	@Column(name="nombre_couverts")
	@JsonView(Views.Common.class)
	private Short nombreCouverts;
	
	@Column(name="cout")
	@JsonView(Views.Common.class)
	private Short cout;
	
	@OneToMany(mappedBy="recette")
	@JsonView(Views.Recette.class)
	private List<RecetteIngredient> listeRecetteIngredient;
	
	@Column(name="instructions")
	@JsonView(Views.Recette.class)
	private String instructions;
	
	@Column(name="conseils")
	@JsonView(Views.Recette.class)
	private String conseils;
	
	@Column(name="image")
	@JsonView(Views.Recette.class)
	private byte[] image;
	
	@Column(name="video")
	@JsonView(Views.Recette.class)
	private byte[] video;
	
	
	public Recette(){
		super();
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
