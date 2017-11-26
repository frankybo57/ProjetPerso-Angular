package noyau.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import noyau.repositories.UtilisateurRepository;

@RestController
public class UtilisateurController {
	@Autowired
	private UtilisateurRepository utiRepo;
}
