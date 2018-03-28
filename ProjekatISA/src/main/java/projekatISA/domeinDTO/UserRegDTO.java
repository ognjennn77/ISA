package projekatISA.domeinDTO;


public class UserRegDTO {
	
	private String  email;
	
	private String name;
	
	private String surname;
	
	private String password1;
	
	private String password2;
	
	private String city;
	
	private int phoneNumber;
	
	
	
	
	public UserRegDTO() {
		
		
	}
	
	public UserRegDTO(String  email, String  name, String  surname, String  password1, String  password2, String  city, int phoneNumber) {
		this.email=email;
		this.name=name;
		this.surname=surname;
		this.password1=password1;
		this.password2=password2;
		this.city=city;
		this.phoneNumber=phoneNumber;	
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
