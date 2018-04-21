package projekatISA.domein;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import projekatISA.domein.User;

@Entity(name="friendship")
public class FriendShip {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//ja
	@ManyToOne
	private User userone;
	
	//prijatelji
	@ManyToOne
	private User usertwo;
	
	@Column(name="status")
	private String status;
	//pending 
	//accepted
	//declined
	
	
	public FriendShip(){
		
		
	}
	
	public FriendShip(User one,User two,String status) {
		this.userone=one;
		this.usertwo=two;
		this.status=status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserone() {
		return userone;
	}

	public void setUserone(User userone) {
		this.userone = userone;
	}

	public User getUsertwo() {
		return usertwo;
	}

	public void setUsertwo(User usertwo) {
		this.usertwo = usertwo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
