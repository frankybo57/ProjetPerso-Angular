package recettes.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import recettes.model.Views;
import recettes.repository.TypeIngredientRepository;
import recettes.service.ListeTypeIngredient;


@RestController
public class TypeIngredientController {
	@Autowired
	private TypeIngredientRepository tiRepo;
	@Autowired
	private ListeTypeIngredient listeTypeIngredient;
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/type-ingredient/liste/")
	@JsonView(Views.Common.class)
	public ResponseEntity<List> findAll() {
		return new ResponseEntity<>(tiRepo.findAll(), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/type-ingredient/liste-hierarchisee/")
	@JsonView(Views.Common.class)
	public ResponseEntity<List> findAllHierarchie() {
		return new ResponseEntity<>(listeTypeIngredient.getListe(), HttpStatus.OK);
	}
}
