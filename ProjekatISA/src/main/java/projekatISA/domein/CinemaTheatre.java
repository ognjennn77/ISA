package projekatISA.domein;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="cinematheatre")
public class CinemaTheatre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name",columnDefinition="VARCHAR(40)")
	private String name;
	
	@Column(name="address",columnDefinition="VARCHAR(60)")
	private String address;
	
	@Column(name="rating")
	private String rating;
	
	@Column(name="description",columnDefinition="VARCHAR(600)")
	private String description;
	
	@Column(name="cinema")
	private boolean cinema;
	
	@OneToOne
	private Repertory repertory;

	public CinemaTheatre() {
		
	}
	
	public CinemaTheatre(String name, String address, String rating, String desription) {
		this.name=name;
		this.address=address;
		this.rating=rating;
		this.description=desription;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCinema() {
		return cinema;
	}

	public void setCinema(boolean isCinema) {
		this.cinema = isCinema;
	}

	public Repertory getRepertory() {
		return repertory;
	}

	public void setRepertory(Repertory repertory) {
		this.repertory = repertory;
	}

}
