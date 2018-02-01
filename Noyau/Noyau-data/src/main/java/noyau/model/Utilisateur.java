package noyau.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonView;

import constantes.Constantes;
import entites.Entite;

/**
 * @author Francois 2
 * @version 0.0.1-Snapshot
 */
@Entity
@SequenceGenerator(name = "default_gen",sequenceName="sequenceUtilisateur")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "login"))
public class Utilisateur extends Entite{
	@Column(name="login", nullable=false)
	@JsonView(Views.Utilisateur.class)
	private String login;
	
	@Column(name="password",columnDefinition="TEXT", nullable=false)
	@JsonView(Views.Utilisateur.class)
	private String password;
	
	@Column(name="droits", nullable=false)
	@JsonView(Views.Utilisateur.class)
	@Enumerated(EnumType.STRING)
	private Droit droits;
	
	public Utilisateur(){
		
	}
	
	public Utilisateur(String login, String password){
		super();
		this.login = login;
		this.password = password;
		this.droits = Droit.UTILISATEUR;
	}

	public Utilisateur(String login, String password, Droit droits) {
		super();
		this.login = login;
		this.password = password;
		this.droits = droits;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the droits
	 */
	public Droit getDroits() {
		return droits;
	}

	/**
	 * @param droits the droits to set
	 */
	public void setDroits(Droit droits) {
		this.droits = droits;
	}

	/** 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = Constantes.PRIME * result + ((login == null) ? 0 : login.hashCode());
		result = Constantes.PRIME * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj))return false;
		
		Utilisateur other = (Utilisateur) obj;
		
		// Test sur le login
		if (login == null) {
			if (other.login != null) return false;
		} 
		else if (!login.equals(other.login)) return false;
		
		// Test sur le mot de passe
		if (password == null) {
			if (other.password != null) return false;
		} 
		else return password.equals(other.password);
		return true;
	}
}
