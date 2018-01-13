package recettes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import recettes.model.TypePlat;

public interface TypePlatRepository extends JpaRepository<TypePlat, Short> {
	@Transactional(readOnly = true)
	@Query("from TypePlat tp order by tp.id asc")
	public List<TypePlat> findAllOrderByIdAsc();
}
