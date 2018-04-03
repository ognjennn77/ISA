package projekatISA.domein;


import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="projectiondate")
public class ProjectionDate {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(value = TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd.MM.yyyy", shape = JsonFormat.Shape.STRING,timezone = "Europe/Madrid")
	@Column(name="date")
	private Date date;
	
	
	@JsonBackReference
	@ManyToOne
	private Projection projection;
	
	@JsonManagedReference
	@OneToMany(mappedBy="projectiondate")
	private Set<ProjectionTerm> projectionTerms = new HashSet();
	
	
	public ProjectionDate() {
		
	}
	
	public ProjectionDate(Date date) {
		this.date=date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}

	
	

}
