package modulerecettes.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	@OneToMany(mappedBy="ingredient")
	private List<RecetteIngredient> listeRecetteIngredient;
}
