package fr.afcepf.al32.groupe2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="authentication",
uniqueConstraints= @UniqueConstraint(columnNames="login"))
public class AuthenticationData {
	
	@Id
	@Column(name="id_user")
	private Long idUser;
	
	@NotNull
	@Size(min=8, max=12)
	private String login;
	
	@NotNull
	private String password;

	@OneToOne(optional=false)
	@PrimaryKeyJoinColumn
	private User user;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getIdUser() {
		return idUser;
	}
	
}
