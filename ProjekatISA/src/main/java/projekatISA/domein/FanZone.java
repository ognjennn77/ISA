package projekatISA.domein;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="fanZone")
public class FanZone {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	//@Column(name="thematicprops")
	//private List<ThematicProps> thematicprops;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

/**
	public List<ThematicProps> getThematicprops() {
		return thematicprops;
	}


	public void setThematicprops(List<ThematicProps> thematicprops) {
		this.thematicprops = thematicprops;
	}
	
	*/
}
