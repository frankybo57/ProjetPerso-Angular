package recettes.api.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import jsonviews.Common;
import recettes.repository.IngredientRepository;

@RestController
public class SupprimerIngredientController {
	
	@Autowired
	private IngredientRepository ingRepo;
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/ingredients/{id}")
	@JsonView(Common.class)
	public ResponseEntity delete(@PathVariable("id") Long id){
		ingRepo.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
}
