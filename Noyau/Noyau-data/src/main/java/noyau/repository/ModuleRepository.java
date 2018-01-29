package noyau.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import noyau.model.Etat;
import noyau.model.Module;

/**
 * Repository JPA relatif à la persistance des modules.
 * 
 * @author frankybo57
 * @version 1.0
 *
 */
public interface ModuleRepository extends JpaRepository<Module, Long> {
	@Transactional(readOnly=true)
	public Module findByNom(String nom);
	
	@Transactional(readOnly=true)
	public List<Module> findAllByEtat(Etat etat);
	
	@Transactional(readOnly=true)
	@Query("from Module m order by m.id asc")
	public List<Module> findAllOrderByIdAsc();
}
