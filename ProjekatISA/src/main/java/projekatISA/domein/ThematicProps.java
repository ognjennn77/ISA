package projekatISA.domein;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="thematicprops")
public class ThematicProps implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private String price;

	@Column(name="reserved")
	private boolean reserved;
	
	
	
	//thematicProps mora da se nalazi u nekom bioskopu
	@ManyToOne(optional=false)
	private CinemaTheatre cinemaTheatre;
	
	//thematicProps ne mora da pripada nekom korisniku(niko ga ne rezervise)
	
	@JsonManagedReference
	@ManyToOne
	private User user;
	
	
	
	
	
	public ThematicProps() {
		
	}
	
	public ThematicProps(String name,String description,String price,CinemaTheatre ct,User user,boolean reserved) {
		this.name = name;
		this.description=description;
		this.price=price;
		this.cinemaTheatre=ct;
		this.user=user;
		this.reserved=reserved;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public CinemaTheatre getCinemaTheatre() {
		return cinemaTheatre;
	}

	public void setCinemaTheatre(CinemaTheatre cinemaTheatre) {
		this.cinemaTheatre = cinemaTheatre;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	
	
	
}
