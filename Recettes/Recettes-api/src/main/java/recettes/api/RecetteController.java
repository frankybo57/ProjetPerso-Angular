package recettes.api;

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
import recettes.model.TypePlat;
import recettes.repository.RecetteRepository;

@RestController
public class RecetteController {
	@Autowired
	private RecetteRepository recRepo;
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/recettes/liste/")
	@JsonView(Common.class)
	public ResponseEntity<List> findAll() {
		return new ResponseEntity<>(recRepo.findAll(), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/recettes/")
	@JsonView(Common.class)
	public ResponseEntity<List> findAll(@RequestBody TypePlat typePlat) {
		return new ResponseEntity<>(recRepo.findAllByTypePlat(typePlat), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/recettes/")
	@JsonView(Common.class)
	public ResponseEntity<List> findAll(@RequestBody Ingredient ingredient) {
		return new ResponseEntity<>(recRepo.findAll(), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/recettes/{difficulte}")
	@JsonView(Common.class)
	public ResponseEntity<List> findAllByDifficulte(@PathVariable("difficulte") Short difficulte){
		List tmp = recRepo.findAllByDifficulte(difficulte);
		
		if(tmp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(tmp,HttpStatus.OK);
		}
	}
}
