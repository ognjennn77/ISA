package projekatISA.serviceInterface;

import projekatISA.domein.User;
import projekatISA.domeinDTO.UserDTO;

public interface UserServiceInterface {
	
	User findUser (String email, String password);
	
	User findUserEdit (UserDTO u);

	User saveUser(UserDTO u);
	
	User acceptRegistration(Long id);
	
	User findUserPassword(UserDTO u);
	
}
