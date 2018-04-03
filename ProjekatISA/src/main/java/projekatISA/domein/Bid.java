package projekatISA.domein;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="bid")
public class Bid {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="offered")
	private String offered;
	
	
	@OneToOne(optional=false)
	private User user;

	@JsonBackReference
	@ManyToOne(optional=false)
	private Announcement announcement;
	
	
	public Bid() {
		
	}
	
	public Bid(String offered,User user) {
		this.offered=offered;
		this.user=user;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getOffered() {
		return offered;
	}


	public void setOffered(String offered) {
		this.offered = offered;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}
	

}