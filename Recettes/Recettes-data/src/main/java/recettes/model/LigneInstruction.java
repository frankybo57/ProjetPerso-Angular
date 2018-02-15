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
@SequenceGenerator(name = "default_gen",sequenceName="SequenceLigneInstruction")
public class LigneInstruction extends Entite {
	@Column(name="instruction")
	@JsonView(Views.Recette.class)
	private String instruction;
	
	@ManyToOne
	@JoinColumn(name="recette_id")
	private Recette recette;
	
	public LigneInstruction() {

	}
	
	public LigneInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public Recette getRecette() {
		return recette;
	}

	public void setRecette(Recette recette) {
		this.recette = recette;
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		LigneInstruction ligneInstruction = (LigneInstruction) obj;
		if(this.instruction == null) {
			return ligneInstruction.getInstruction() == null;
		}
		else {
			return this.instruction.equals(ligneInstruction.getInstruction());
		}
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = Constantes.PRIME * result + ((recette == null) ? 0 : recette.hashCode());
		result = Constantes.PRIME * result + ((instruction == null) ? 0 : instruction.hashCode());
		return result;
	}
}
