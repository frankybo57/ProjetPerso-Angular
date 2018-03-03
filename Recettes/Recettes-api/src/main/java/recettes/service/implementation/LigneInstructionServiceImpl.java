/**
 * 
 */
package recettes.service.implementation;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recettes.model.LigneInstruction;
import recettes.repository.LigneInstructionRepository;
import recettes.service.LigneInstructionService;

/**
 * Implémentation de l'interface LigneInstructionService
 * 
 * @author Dev
 *
 */
@Service
public class LigneInstructionServiceImpl implements LigneInstructionService {
	@Autowired
	private LigneInstructionRepository liRepo;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LigneInstruction> findListLigneInstructionByRecette(Long id) {
		return liRepo.findAllByRecette(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String findTextLigneInstructionByRecette(final Long id) {
		final List<LigneInstruction> liste = liRepo.findAllByRecette(id);
		
		if(!liste.isEmpty()) {
			StringBuilder instructions = new StringBuilder();
			Iterator<LigneInstruction> it = liste.iterator();
			LigneInstruction instruction;
			while(it.hasNext()) {
				instruction = it.next();
				instructions.append(instruction.getInstruction());
				instructions.append(String.format("%n", ""));
			}
			return instructions.toString();
		}
		else {
			return "Cette recette n'a pas encore d'instructions.";
		}
	}
}
