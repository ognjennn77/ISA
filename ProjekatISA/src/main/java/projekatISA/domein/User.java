package projekatISA.domein;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="email")
	private String email;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@NotNull
	@Column(name="password")
	private String password;
	
	@Column(name="city")
	private String city;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="active")
	private boolean active;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="user")
	private Set<ThematicProps> thematicProps;
	
	
	
	public User() {
		
	}
	
	
	public User(String email, String name, String surname, String password, String city, String phoneNumber,boolean active) {
		this.email=email;
		this.name=name;
		this.surname=surname;
		this.password=password;
		this.city=city;
		this.phoneNumber=phoneNumber;
		this.active=active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Set<ThematicProps> getThematicProps() {
		return thematicProps;
	}


	public void setThematicProps(Set<ThematicProps> thematicProps) {
		this.thematicProps = thematicProps;
	}
	
}
