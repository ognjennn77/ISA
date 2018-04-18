package projekatISA.domein;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	
	
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy="user")
	private Set<ThematicProps> thematicProps = new HashSet();
	
	
	
	@JsonManagedReference
	@OneToMany(mappedBy="user1")
	private Set<Reservation> reservations = new HashSet();
	
	/**
	 * adminF - admin fan zone
	 * adminS - admin sistema
	 * user - korisnik
	 */
	@Column(name="role")
	private String role;
	
	
	
	public User() {
		
	}
	
	
	public User(String email, String name, String surname, String password, String city, String phoneNumber,boolean active,String role) {
		this.email=email;
		this.name=name;
		this.surname=surname;
		this.password=password;
		this.city=city;
		this.phoneNumber=phoneNumber;
		this.active=active;
		this.role=role;
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

	

	public List<ThematicProps> getThematicProps() {	
		List<ThematicProps> thematicP = new ArrayList<>(thematicProps);
		if(thematicP.size()>0) {
			return thematicP;
		}
		return null;
	}


	public void setThematicProps(Set<ThematicProps> thematicProps) {
		this.thematicProps = thematicProps;
	}


	

	
	


	public List<Reservation> getReservations() {
		List<Reservation> res = new ArrayList<>(reservations);
		if(res.size()>0) {
			return res;
		}
		return null;
	}


	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}




}
