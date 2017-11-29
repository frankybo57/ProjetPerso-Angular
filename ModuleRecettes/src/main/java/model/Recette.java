package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
@SequenceGenerator(name="sequenceRecette",sequenceName="SequenceRecette")
public class Recette {
	@Id @GeneratedValue(generator="sequenceRecette")
	private Integer id;
	
	@Version
	private int version;
	
	@Column(name="label")
	private String label;
	
	public Recette(){
		
	}
}
