package projekatISA.domeinDTO;

public class CinemaTheatreDTO {

	private String name;
	
	private String address;
	
	private String rating;
	
	private String description;
	
	private boolean iscinema;
	
	private float longitude;
	
	private float latitude;
	
	public CinemaTheatreDTO() {
		
	
	}
	
	public CinemaTheatreDTO(String name, String address, String rating, String description) {
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

	public boolean isIscinema() {
		return iscinema;
	}

	public void setIscinema(boolean iscinema) {
		this.iscinema = iscinema;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	
	
	
	
}
