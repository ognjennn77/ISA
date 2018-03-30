package projekatISA.domein;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;;


@Entity(name="repertory")
public class Repertory {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private CinemaTheatre cinemaTheatre;
	
	public Repertory() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CinemaTheatre getCinemaTheatre() {
		return cinemaTheatre;
	}

	public void setCinemaTheatre(CinemaTheatre cinemaTheatre) {
		this.cinemaTheatre = cinemaTheatre;
	}
	
	

	

}
