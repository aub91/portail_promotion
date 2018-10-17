package fr.afcepf.al32.groupe2.entity;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="core_user")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type")
@NamedNativeQueries(value= {
		@NamedNativeQuery(name="Client.findAllFollowingFollowableElement", 
				query="SELECT cli.id, cli.first_name, cli.last_name, cli.phone_number, cli.email FROM core_user as cli INNER JOIN following_element_data as fed ON cli.id = fed.subscriber_id "
						+ "WHERE cli.user_type = 'CLIENT' AND fed.element_id = 1 AND fed.element_type = 'CATEGORY' AND fed.follow_end_date IS NULL",resultClass=User.class)
		
})
public abstract class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="last_name")
	@NotBlank
	private String lastName;
	
	@Column(name="first_name")
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String email;
	
	@Column(name="phone_number")
	@NotNull
	private String phoneNumber;
	
	@OneToOne(mappedBy="user",cascade= {CascadeType.ALL}, optional=false)
	@NotNull
	private AuthenticationData authenticationData;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	@MapKey(name="id")
	private Map<Long, UserRegistration> registrations;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}
	
	
}
