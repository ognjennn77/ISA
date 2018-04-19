package projekatISA.serviceInterface;

import java.util.List;
import java.util.Set;

import projekatISA.domein.Notification;
import projekatISA.domein.ThematicProps;
import projekatISA.domein.User;
import projekatISA.domeinDTO.UserDTO;

public interface UserServiceInterface {
	
	UserDTO findUser (String email, String password);
	
	User findUserEdit (UserDTO u);

	User saveUser(UserDTO u);
	
	User acceptRegistration(Long id);
	
	User findUserPassword(UserDTO u);

	List<ThematicProps> findThematicProps(Long id);
	
	List<Notification> findNotification(Long id);
	
	UserDTO addAdministrator(User u);
	
	List<User> getAdminOfCT();
	
	UserDTO getUserid(Long id);
}
