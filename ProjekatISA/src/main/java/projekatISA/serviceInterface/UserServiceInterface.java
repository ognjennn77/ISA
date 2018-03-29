package projekatISA.serviceInterface;

import projekatISA.domein.User;
import projekatISA.domeinDTO.UserEditPasswordDTO;
import projekatISA.domeinDTO.UserLogDTO;
import projekatISA.domeinDTO.UserRegDTO;

public interface UserServiceInterface {
	
	User findUser (String email, String password);
	
	User findUserEdit (UserRegDTO u);

	User saveUser(UserRegDTO u);
	
	User acceptRegistration(Long id);
	
	User findUserPassword(UserEditPasswordDTO u);
	
}
