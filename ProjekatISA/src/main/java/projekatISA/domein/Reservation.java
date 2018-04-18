
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

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	private List<Seat> seats;
	
	@JsonBackReference
	@ManyToOne
	private User user1;
	
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

	

	

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	
	

}


