package noyau.model;

/**
 * @author Francois 2
 * @version 0.0.1-Snapshot
 */
public enum Droit {
	ADMINISTRATEUR("Droit.Administrateur"),
	UTILISATEUR("Droit.Utilisateur");
	
	private final String label;

	private Droit(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
