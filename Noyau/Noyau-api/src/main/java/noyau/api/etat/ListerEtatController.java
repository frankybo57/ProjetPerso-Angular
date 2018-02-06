package noyau.api.etat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import noyau.model.Etat;

@RestController
public class ListerEtatController {

	@GetMapping("/modules/etats")
	public ResponseEntity<Etat[]> findAllEtats() {
		return new ResponseEntity<>(Etat.values(), HttpStatus.OK);
	}
}
