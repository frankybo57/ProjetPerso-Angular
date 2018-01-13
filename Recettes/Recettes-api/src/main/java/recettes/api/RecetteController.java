package recettes.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import recettes.model.Ingredient;
import recettes.model.Recette;
import recettes.model.TypePlat;
import recettes.model.Views;
import recettes.repository.RecetteRepository;

@RestController
public class RecetteController {
	@Autowired
	private RecetteRepository recRepo;
	
	@GetMapping("/recettes/")
	@JsonView(Views.Common.class)
	public ResponseEntity<List<Recette>> findAll() {
		return new ResponseEntity<>(recRepo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/recettes/{typeplat}")
	@JsonView(Views.Common.class)
	public ResponseEntity<List<Recette>> findAll(@PathVariable("typeplat") TypePlat typePlat) {
		return new ResponseEntity<>(recRepo.findAllByTypePlat(typePlat), HttpStatus.OK);
	}
	
	@GetMapping("/recettes/{ingredient}")
	@JsonView(Views.Common.class)
	public ResponseEntity<List<Recette>> findAll(@PathVariable("ingredient") Ingredient ingredient) {
		return new ResponseEntity<>(recRepo.findAll(), HttpStatus.OK);
	}
}
