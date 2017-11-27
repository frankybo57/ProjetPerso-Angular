/**
 * 
 */
package noyau.repositories;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import noyau.model.Droit;
import noyau.model.Utilisateur;

/**
 * @author Francois 2
 * @version 1.0
 *
 */

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	@Transactional(readOnly=true)
	public Utilisateur findByLogin(String login);
	@Transactional(readOnly=true)
	public List<Utilisateur> findAllByDroits(Droit droits);
}
