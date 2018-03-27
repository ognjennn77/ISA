package projekatISA.serviceInterface;

import projekatISA.domein.User;

public interface UserServiceInterface {
	
	User findUser (String email, String password);

}
