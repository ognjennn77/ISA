package projekatISA.domein;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="cinema")
public class Cinema {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name",columnDefinition="VARCHAR(40)")
	private String name;
	
	@Column(name="address",columnDefinition="VARCHAR(60)")
	private String address;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="description",columnDefinition="VARCHAR(600)")
	private String description;

	public Cinema() {
		
	}
	
	public Cinema(String name, String address, int rating, String desription) {
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
