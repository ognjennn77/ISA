package projekatISA.serviceInterface;

import projekatISA.domein.User;
import projekatISA.domeinDTO.UserRegDTO;

public interface UserServiceInterface {
	
	User findUser (String email, String password);

	User saveUser(UserRegDTO u);
	
	User acceptRegistration(Long id);
	
}
