package projekatISA.domein;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="notification")
public class Notification {

	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="description")
	private String description;

	@Column(name="type")
	private String type;
	
	
	
	@JsonBackReference
	@ManyToOne(optional=false)
	private User user;
	
	
	
	public Notification() {
		
		
	}
	
	
	public Notification(Long id, String description,String type) {
		this.id = id;
		this.description = description;
		this.type=type;
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	



}
