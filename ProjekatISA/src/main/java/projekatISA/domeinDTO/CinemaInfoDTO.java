package projekatISA.domeinDTO;

public class CinemaInfoDTO {

	private String name;
	
	private String address;
	
	private String rating;
	
	private String description;
	
	public CinemaInfoDTO() {
		
	
	}
	
	public CinemaInfoDTO(String name, String address, String rating, String description) {
		this.name=name;
		this.address=address;
		this.rating=rating;
		this.description=description;
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

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
}
