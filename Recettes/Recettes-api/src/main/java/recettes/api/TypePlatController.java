package recettes.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import jsonviews.Common;
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
	@JsonView(Common.class)
	public ResponseEntity<List> findAll() {
		return new ResponseEntity<>(tpRepo.findAllOrderByIdAsc(), HttpStatus.OK);
	}
}
