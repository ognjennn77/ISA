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
	
	@ManyToOne
	private User userone;

	@Column(name="description")
	private String description;

	@Column(name="type")
	private String type;
	
	@JsonBackReference
	@ManyToOne
	private User usertwo;
	
	//koji oglas administrator treba da odobrava
	
	@ManyToOne(optional=true)
	private Announcement announcement;
	
	
	public Notification() {
		
		
	}
	
	
	public Notification(Long id, String description,String type,Announcement an) {
		this.id = id;
		this.description = description;
		this.type=type;
		this.announcement=an;
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




	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public User getUserone() {
		return userone;
	}


	public void setUserone(User userone) {
		this.userone = userone;
	}


	public User getUsertwo() {
		return usertwo;
	}


	public void setUsertwo(User usertwo) {
		this.usertwo = usertwo;
	}


	public Announcement getAnnouncement() {
		return announcement;
	}


	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}



	


	
	
	



}
