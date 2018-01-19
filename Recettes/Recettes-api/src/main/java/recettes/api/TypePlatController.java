package recettes.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import recettes.model.TypePlat;
import recettes.model.Views;
import recettes.repository.TypePlatRepository;


@RestController
public class TypePlatController {
	@Autowired
	private TypePlatRepository tpRepo;
	
	/**
	 * 
	 * @return tous les types de plats en base.
	 */
	@GetMapping("/typesPlats/")
	@JsonView(Views.Common.class)
	public ResponseEntity<List<TypePlat>> findAll() {
		return new ResponseEntity<>(tpRepo.findAllOrderByIdAsc(), HttpStatus.OK);
	}
	
	@GetMapping("/typesPlats/{typeplat}")
	@JsonView(Views.Common.class)
	@Deprecated
	public ResponseEntity<List<TypePlat>> findAll(@PathVariable("typeplat") TypePlat typePlat) {
		return new ResponseEntity<>(tpRepo.findAllOrderByIdAsc(), HttpStatus.OK);
	}
}
