package modulerecettes.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import modulerecettes.model.Recette;
import modulerecettes.model.Views;
import modulerecettes.repository.RecetteRepository;

@RestController
public class RecetteController {
	@Autowired
	private RecetteRepository recRepo;
	
	@GetMapping("/recettes/")
	@JsonView(Views.Common.class)
	public ResponseEntity<List<Recette>> findAll() {
		return new ResponseEntity<List<Recette>>(recRepo.findAll(), HttpStatus.OK);
	}
}
