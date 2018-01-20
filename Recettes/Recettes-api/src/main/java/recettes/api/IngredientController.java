package recettes.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import recettes.model.Recette;
import recettes.model.TypeIngredient;
import recettes.model.Views;
import recettes.repository.IngredientRepository;

@RestController
public class IngredientController {
	
	@Autowired
	private IngredientRepository ingRepo;
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/ingredients/")
	@JsonView(Views.Common.class)
	public ResponseEntity<List> findAll(){
		List tmp = ingRepo.findAll();
		
		if(tmp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(tmp,HttpStatus.OK);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/ingredients/{typeingredient}")
	@JsonView(Views.Common.class)
	public ResponseEntity<List> findAllByTypeIngredient(TypeIngredient typeIngredient){
		List tmp = ingRepo.findAllByTypeIngredient(typeIngredient);
		
		if(tmp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(tmp,HttpStatus.OK);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/ingredients/{recette}")
	@JsonView(Views.Common.class)
	public ResponseEntity<List> findAllByRecette(@PathVariable("recette") Recette recette){
		List tmp = ingRepo.findAllIngredientByRecette(recette);
		
		if(tmp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(tmp,HttpStatus.OK);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/ingredients/{cout}")
	@JsonView(Views.Common.class)
	public ResponseEntity<List> findAllByPrix(@PathVariable("cout") Short cout){
		List tmp = ingRepo.findAllByCout(cout);
		
		if(tmp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(tmp,HttpStatus.OK);
		}
	}
	
	
	
	
}
