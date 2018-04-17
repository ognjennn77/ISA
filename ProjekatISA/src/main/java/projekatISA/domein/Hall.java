package projekatISA.domein;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Hall {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ordinal")
	private String ordinal;
		
	
	@JsonBackReference
	@ManyToOne
	private CinemaTheatre cinematheatre;
	
	//@JsonManagedReference
	//@OneToMany(mappedBy="hall")
	//private Set<Seat> seats = new HashSet();
	
	public Hall() {
		
	}
	
	public Hall(String ordinal) {
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

	

	public CinemaTheatre getCinematheatre() {
		return cinematheatre;
	}

	public void setCinematheatre(CinemaTheatre cinematheatre) {
		this.cinematheatre = cinematheatre;
	}



}
