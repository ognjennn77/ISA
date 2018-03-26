package projekatISA.domein;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="theatre")
public class Theatre {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name",columnDefinition="VARCHAR(40)")
	private String name;
	
	@Column(name="address",columnDefinition="VARCHAR(40)")
	private String address;
	
	@Column(name="rating")
	private int raiting;

	@Column(name="description",columnDefinition="VARCHAR(600)")
	private String description;
	
	public Theatre() {
		
	}
	
	public Theatre(String n,String a,String d,int r) {
		this.name=n;
		this.address=a;
		this.description=d;
		this.raiting=r;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRaiting() {
		return raiting;
	}

	public void setRaiting(int raiting) {
		this.raiting = raiting;
	}
	

}
