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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="seat")
public class Seat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ordinal")
	private String ordinal;
	
	//@JsonBackReference
	//@ManyToOne
	//private Hall hall;
	
	@ManyToMany
	private Set<ProjectionTerm> projectiont = new HashSet();
	
	@Column(name="reserved")
	private boolean reserved;

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

	public List<ProjectionTerm> getProjectiont() {
		List<ProjectionTerm> Pt = new ArrayList<>(projectiont);
		if(Pt.size()>0) {
			return Pt;
		}
		return null;
	}

	public void setProjectiont(Set<ProjectionTerm> projectiont) {
		this.projectiont = projectiont;
	}

	

}
