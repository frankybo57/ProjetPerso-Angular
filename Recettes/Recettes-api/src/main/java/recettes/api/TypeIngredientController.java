package recettes.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import recettes.model.TypeIngredient;
import recettes.model.Views;
import recettes.repository.TypeIngredientRepository;


@RestController
public class TypeIngredientController {
	@Autowired
	private TypeIngredientRepository tiRepo;
	
	@GetMapping("/type-ingredient/liste/")
	@JsonView(Views.TypeIngredient.class)
	public ResponseEntity<List<TypeIngredient>> findAll() {
		return new ResponseEntity<>(tiRepo.findAll(), HttpStatus.OK);
	}
}
