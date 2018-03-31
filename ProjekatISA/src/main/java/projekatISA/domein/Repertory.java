package projekatISA.domein;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;;


@Entity(name="repertory")
public class Repertory {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//treba staviti optional=false
	@OneToOne
	@JoinColumn(name="cinema_theatre_id")
	private CinemaTheatre cinematheatre;
	
	@OneToMany(mappedBy="repertory")
	private Set<Projection> projections;
	
	public Repertory() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Set<Projection> getProjections() {
		return projections;
	}

	public void setProjections(Set<Projection> projections) {
		this.projections = projections;
	}

	public CinemaTheatre getCinemaTheatre() {
		return cinematheatre;
	}

	public void setCinemaTheatre(CinemaTheatre cinemaTheatre) {
		this.cinematheatre = cinemaTheatre;
	}
	
	

	

}
