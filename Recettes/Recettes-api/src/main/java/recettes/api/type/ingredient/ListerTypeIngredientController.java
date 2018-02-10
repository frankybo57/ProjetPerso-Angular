package recettes.api.type.ingredient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import jsonviews.Common;
import recettes.service.TypeIngredientService;


@RestController
public class ListerTypeIngredientController {
	@Autowired
	private TypeIngredientService tiService;
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/type-ingredient/liste/")
	@JsonView(Common.class)
	public ResponseEntity<List> findAll() {
		return new ResponseEntity<>(tiService.findAll(), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/type-ingredient/liste/hierarchisee/")
	@JsonView(Common.class)
	public ResponseEntity<List> findAllHierarchie() {
		return new ResponseEntity<>(tiService.getListe(), HttpStatus.OK);
	}
}
