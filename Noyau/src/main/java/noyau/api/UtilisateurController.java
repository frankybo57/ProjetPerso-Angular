package noyau.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import noyau.Verrou;
import noyau.model.Droit;
import noyau.model.Utilisateur;
import noyau.model.Views;
import noyau.repositories.UtilisateurRepository;

@RestController
public class UtilisateurController {
	@Autowired
	private UtilisateurRepository utiRepo;
	
	@GetMapping("/utilisateur/{login}:{password}")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> findOne(@PathVariable("login") String login, @PathVariable("password") String password) {
		Utilisateur tmp = utiRepo.findOneByLoginAndByPassword(login,password);
		if (tmp != null) {
			tmp.setPassword("");
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/utilisateur/code/{login}:{password}")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> findOneCode(@PathVariable("login") String login, @PathVariable("password") String password) {
		Utilisateur tmp = utiRepo.findOneByLoginAndByPassword(login,Verrou.cryptage(password));
		System.out.println(tmp);
		if (tmp != null) {
			tmp.setPassword("");
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/utilisateur/")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> createOne(@RequestBody Utilisateur obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		obj.setDroits(Droit.Utilisateur);
		obj = utiRepo.save(obj);
		obj.setPassword("");

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}
	
	@PostMapping("/utilisateur/code/")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> createOneCode(@RequestBody Utilisateur obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		String passwordCode = Verrou.cryptage(obj.getPassword());
		
		obj.setPassword(passwordCode);
		obj.setDroits(Droit.Utilisateur);
		obj = utiRepo.save(obj);
		obj.setPassword("");
		
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}
}
