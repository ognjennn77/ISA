package projekatISA.domeinDTO;

public class UserEditPasswordDTO {
	
	private String email;
	
	private String currentPassword;
	
	private String newPassword;
	
	private String repeatPassword;
	
	
	UserEditPasswordDTO(){
		
		
	}
	
	
	UserEditPasswordDTO(String email, String currentPassword, String newPassword, String repeatPassword){
		
		this.email=email;
		this.currentPassword=currentPassword;
		this.newPassword=newPassword;
		this.repeatPassword=repeatPassword;
		
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCurrentPassword() {
		return currentPassword;
	}


	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
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
