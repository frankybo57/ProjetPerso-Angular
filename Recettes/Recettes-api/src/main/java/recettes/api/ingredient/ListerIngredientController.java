package recettes.api.ingredient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import jsonviews.Common;
import recettes.model.Ingredient;
import recettes.model.Recette;
import recettes.model.TypeIngredient;
import recettes.service.IngredientService;

@RestController
public class ListerIngredientController {

	@Autowired
	private IngredientService ingService;
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/ingredients/liste/")
	@JsonView(Common.class)
	public ResponseEntity<List> findAll(){
		List<Ingredient> tmp = ingService.findAll();
		
		if(tmp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(tmp,HttpStatus.OK);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/ingredients/liste/type-ingredient")
	@JsonView(Common.class)
	public ResponseEntity<List> findAllByTypeIngredient(@RequestBody TypeIngredient typeIngredient){
		List<Ingredient> tmp = ingService.findAllByTypeIngredient(typeIngredient);
		
		if(tmp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(tmp,HttpStatus.OK);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/ingredients/liste/recette")
	@JsonView(Common.class)
	public ResponseEntity<List> findAllByRecette(@RequestBody Recette recette){
		List<Ingredient> tmp = ingService.findAllByRecette(recette);
		
		if(tmp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(tmp,HttpStatus.OK);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/ingredients/{cout}")
	@JsonView(Common.class)
	public ResponseEntity<List> findAllByPrix(@PathVariable("cout") Short cout){
		List<Ingredient> tmp = ingService.findAllByPrix(cout);
		
		if(tmp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(tmp,HttpStatus.OK);
		}
	}

}
