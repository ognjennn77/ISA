package projekatISA.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.Notification;
import projekatISA.domein.ThematicProps;
import projekatISA.domein.User;
import projekatISA.domeinDTO.UserDTO;
import projekatISA.repository.RepositoryUser;
import projekatISA.serviceInterface.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface{

	@Autowired
	private RepositoryUser repositoryUser;
	
	@Override
	public UserDTO findUser(String email, String password) {
		
		User user = repositoryUser.findByEmailEqualsAndPasswordEquals(email, password);
		UserDTO userdto = new UserDTO();
		if(!(user==null)) {	
			
			if(user.isActive()) {
				userdto.setId(user.getId());
				userdto.setEmail(user.getEmail());
				userdto.setName(user.getName());
				userdto.setCity(user.getCity());
				userdto.setPassword(user.getPassword());
				userdto.setPhoneNumber(user.getPhoneNumber());
				userdto.setSurname(user.getSurname());
				userdto.setRole(user.getRole());
				userdto.setAdminFchangep(user.getAdminFchangeP());
				return userdto;
			}
		}
		
		return null;
	}
	
	

	@Override
	public User saveUser(UserDTO u) {
		
		if(u.getNewPassword().equals(u.getRepeatPassword())) {
			User user = new User();
			user.setEmail(u.getEmail());
			user.setName(u.getName());
			user.setSurname(u.getSurname());
			user.setPassword(u.getNewPassword());
			user.setCity(u.getCity());
			user.setPhoneNumber(u.getPhoneNumber());
			user.setRole(u.getRole());
			if(u.getRole().equals("adminF")) {
				user.setAdminFchangeP("no");
			}
			else {
				user.setAdminFchangeP("yes");
			}
			User user1 = repositoryUser.findByEmailEquals(user.getEmail());
			if(user1==null) {
				return repositoryUser.save(user);
			}			
		}	
		return null;
	}

	
	
	@Override
	public User acceptRegistration(Long id) {
		User user = repositoryUser.findByIdEquals(id);
		if(!(user==null)) {
			user.setActive(true);
			repositoryUser.save(user);
			return user;
		}
		return user;
	}


	

	@Override
	public User findUserEdit(UserDTO u) {
		User user = repositoryUser.findByEmailEquals(u.getEmail());
		if(!(user==null)) {
			user.setEmail(u.getEmail());	
			user.setName(u.getName());
			user.setSurname(u.getSurname());
			user.setCity(u.getCity());
			user.setPhoneNumber(u.getPhoneNumber());
			repositoryUser.save(user);
			return user; 
		}
		
		return null;
	}



	@Override
	public User findUserPassword(UserDTO u) {
		
		User user = repositoryUser.findByEmailEquals(u.getEmail());
		
		if(user==null) {
			return null;
		}
		
		if(user.getPassword().equals(u.getPassword())) {		
			if(u.getNewPassword().equals(u.getRepeatPassword())) {			
				user.setPassword(u.getNewPassword());
				if(user.getAdminFchangeP().equals("no")) {
					user.setAdminFchangeP("yes");
				}
				repositoryUser.save(user);				
				return user;
			}	
		}
				
		return null;
	}



	@Override
	public List<ThematicProps> findThematicProps(Long id) {
		User user = repositoryUser.findByIdEquals(id);
		if(!(user==null)) {
			List<ThematicProps> t = user.getThematicProps();
			
			if(!(t==null)) {
				return t;
			}
		}
		return null;
	}



	@Override
	public List<Notification> findNotification(Long id) {
		User user = repositoryUser.findByIdEquals(id);
		if(!(user==null)) {
			//List<Notification> notifi = user.getNotification();
			
			//if(!(notifi==null)) {
			//	return notifi;
		//	}
		}
		return null;
	}
		
}
