/**
 * 
 */
package noyau.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import noyau.model.Etat;
import noyau.model.Module;

/**
 * @author Francois 2
 * @version 1.0
 *
 */

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {
	@Transactional(readOnly=true)
	public Module findByNom(String nom);
	@Transactional(readOnly=true)
	public List<Module> findAllByEtat(Etat etat);
}
