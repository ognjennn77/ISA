package projekatISA.domein;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	//treba staviti optional=false
	@ManyToOne
	private Repertory repertory;
	
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
	

}
