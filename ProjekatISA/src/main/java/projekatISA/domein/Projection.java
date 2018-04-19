package projekatISA.domein;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="projection")
public class Projection {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="actors")
	private String actors;
	
	@Column(name="runtime")
	private String runtime;
	
	@JsonBackReference
	@ManyToOne
	private Repertory repertory;
	
	@JsonManagedReference
	@OneToMany(mappedBy="projection")
	private Set<ProjectionDate> projectionDates = new HashSet();
	
	
	public Projection() {
				
	}
	
	
	public Projection(String name, String actors, String runtime) {
		this.name=name;
		this.actors=actors;
		this.runtime=runtime;
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

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}


	public Repertory getRepertory() {
		return repertory;
	}


	public void setRepertory(Repertory repertory) {
		this.repertory = repertory;
	}


	public List<ProjectionDate> getProjectionDates() {
		List<ProjectionDate> pd = new ArrayList<>(projectionDates);
		if(pd.size()>0) {
			return pd;
		}
		return null;
	}
	public Set<ProjectionDate> getProjectionDatess() {

		return projectionDates;
	}


	public void setProjectionDates(Set<ProjectionDate> projectionDates) {
		this.projectionDates = projectionDates;
	}
	
	


}
