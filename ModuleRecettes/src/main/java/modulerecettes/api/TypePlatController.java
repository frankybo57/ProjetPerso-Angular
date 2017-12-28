package modulerecettes.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import modulerecettes.model.TypePlat;
import modulerecettes.model.Views;
import modulerecettes.repository.TypePlatRepository;


@RestController
public class TypePlatController {
	@Autowired
	private TypePlatRepository tpRepo;
	
	@GetMapping("/typesPlats/")
	@JsonView(Views.Common.class)
	public ResponseEntity<List<TypePlat>> findAll() {
		return new ResponseEntity<>(tpRepo.findAllOrderByIdAsc(), HttpStatus.OK);
	}
}
