package noyau.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author Francois 2
 * @version 0.0.1-Snapshot
 */
@Entity
@SequenceGenerator(name = "sequenceUtilisateur",sequenceName="sequenceUtilisateur")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "login"))
public class Utilisateur {
	
	@Id @GeneratedValue(generator = "sequenceUtilisateur")
	@Column(name="id")
	@JsonView(Views.Common.class)
	private Integer id;
	
	@Version
	@Column(name="version")
	@JsonView(Views.Common.class)
	private int version;
	
	@Column(name="login")
	@JsonView(Views.Utilisateur.class)
	private String login;
	
	@Column(name="password",columnDefinition="TEXT")
	@JsonView(Views.Utilisateur.class)
	private String password;
	
	@Column(name="droits")
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
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}
	
	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((droits == null) ? 0 : droits.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if ((obj == null) || (getClass() != obj.getClass())) return false;
		Utilisateur other = (Utilisateur) obj;
		if (droits != other.droits) return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
}
