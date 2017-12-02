package modulerecettes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import modulerecettes.model.TypePlat;

public interface TypePlatRepository extends JpaRepository<TypePlat, Short> {
	@Query("from TypePlat tp order by tp.id asc")
	public List<TypePlat> findAllOrderByIdAsc();
}
