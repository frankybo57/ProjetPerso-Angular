package recettes.api.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import exception.IngredientException;
import jsonviews.Common;
import recettes.service.IngredientService;

@RestController
public class SupprimerIngredientController {
	
	@Autowired
	private IngredientService ingService;
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/ingredients/{id}")
	@JsonView(Common.class)
	public ResponseEntity delete(@PathVariable("id") final Long id){
		try {
			ingService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(final IngredientException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
}
