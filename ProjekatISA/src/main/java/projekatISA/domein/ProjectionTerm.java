package projekatISA.domein;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="projectionterm")
public class ProjectionTerm {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Temporal(value = TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING,timezone = "Europe/Madrid")
	@Column(name="term")
	private Date term;
	
	
	@JsonBackReference
	@ManyToOne
	private ProjectionDate projectiondate;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getTerm() {
		return term;
	}


	public void setTerm(Date term) {
		this.term = term;
	}


	public ProjectionDate getProjectiondate() {
		return projectiondate;
	}


	public void setProjectiondate(ProjectionDate projectiondate) {
		this.projectiondate = projectiondate;
	}
	

}
