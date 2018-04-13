package projekatISA.domeinDTO;

public class ThematicPropsDTO {

	

	private String id;
	
	private String name;
	
	private String description;
	
	private String price;
	
	private String reserved;
	
	private String cinema_theatre_id;
	
	private String user_id;

	
	public ThematicPropsDTO(String id, String name, String description, String price, String reserved,
			String cinema_theatre_id, String user_id) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.reserved = reserved;
		this.cinema_theatre_id = cinema_theatre_id;
		this.user_id = user_id;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	public String getCinema_theatre_id() {
		return cinema_theatre_id;
	}

	public void setCinema_theatre_id(String cinema_theatre_id) {
		this.cinema_theatre_id = cinema_theatre_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
}
