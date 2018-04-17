package projekatISA.domein;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="ordinal")
	private String ordinal;
	
	@ManyToOne
	private ProjectionTerm projectionterm;
	
	@OneToMany
	private Set<Seat> seats = new HashSet();
	
	@ManyToOne
	private User user;
	
	Reservation(){
		
	}
	
	Reservation(String ordinal){
		this.ordinal=ordinal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(String ordinal) {
		this.ordinal = ordinal;
	}

	public ProjectionTerm getProjectionterm() {
		return projectionterm;
	}

	public void setProjectionterm(ProjectionTerm projectionterm) {
		this.projectionterm = projectionterm;
	}

	public List<Seat> getSeats() {
		List<Seat> s = new ArrayList<>(seats);
		if(s.size()>0) {
			return s;
		}
		return null;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
