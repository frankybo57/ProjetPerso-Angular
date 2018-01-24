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
	 * @return la liste des types de plats en base.
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/types-plats/liste/")
	@JsonView(Views.Common.class)
	public ResponseEntity<List> findAll() {
		return new ResponseEntity<>(tpRepo.findAllOrderByIdAsc(), HttpStatus.OK);
	}
	
	/**
	 * @deprecated
	 * @param typePlat -
	 * @return -
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/types-plats/{typeplat}")
	@JsonView(Views.Common.class)
	@Deprecated
	public ResponseEntity<List> findAll(@PathVariable("typeplat") TypePlat typePlat) {
		return new ResponseEntity<>(tpRepo.findAllOrderByIdAsc(), HttpStatus.OK);
	}
}
