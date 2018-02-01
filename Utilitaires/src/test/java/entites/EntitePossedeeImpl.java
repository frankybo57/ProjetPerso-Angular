package entites;

public class EntitePossedeeImpl extends EntitePossedee {
	
	public EntitePossedeeImpl() {
		super();
	}

	public EntitePossedeeImpl(String label, Integer utilisateur, Boolean prive) {
		super(label, utilisateur, prive);
	}

	public EntitePossedeeImpl(String label, Integer utilisateur) {
		super(label, utilisateur);
	}

	public EntitePossedeeImpl(String label) {
		super(label);
	}
}
