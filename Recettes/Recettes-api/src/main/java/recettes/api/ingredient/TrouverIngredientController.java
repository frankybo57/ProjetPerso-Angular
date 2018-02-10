package recettes.api.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import jsonviews.Common;
import recettes.model.Ingredient;
import recettes.service.IngredientService;

@RestController
public class TrouverIngredientController {

	@Autowired
	private IngredientService ingService;
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/ingredients/{id}")
	@JsonView(Common.class)
	public ResponseEntity find(@PathVariable("id") Long id){
		Ingredient tmp = ingService.find(id);
		
		if(tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(tmp,HttpStatus.OK);
		}
	}
}
