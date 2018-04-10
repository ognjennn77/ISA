package projekatISA.domeinDTO;

public class UserDTO {
	
	
	private String email;
	
	private String name;
	
	private String surname;
	
	private String city;
	
	private String phoneNumber;
	
	private String Password;
	
	private String newPassword;
	
	private String repeatPassword;
	
	public UserDTO() {
		
	}
	
	public UserDTO(String email, String name, String surname, String city, String phoneNumber, String Password, String newPassword, String repeatPassword) {
		this.email=email;
		this.name=name;
		this.surname=surname;
		this.city=city;
		this.phoneNumber=phoneNumber;
		this.Password=Password;
		this.newPassword=newPassword;
		this.repeatPassword=repeatPassword;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	
	

}
