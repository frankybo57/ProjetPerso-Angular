package noyau.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import noyau.model.Droit;
import noyau.model.Utilisateur;

/**
 * Repository JPA relatif à la persistance des utilisateurs.
 * 
 * @author frankybo57
 * @version 1.0
 *
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	@Transactional(readOnly=true)
	public Utilisateur findByLogin(String login);
	
	@Transactional(readOnly=true)
	public List<Utilisateur> findAllByDroits(Droit droits);
	
	@Transactional(readOnly=true)
	@Query("select u from Utilisateur u where u.login = :login and u.password = :password")
	public Utilisateur findOneByLoginAndByPassword(@Param("login") String login, @Param("password") String password);
}
