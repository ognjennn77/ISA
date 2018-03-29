package projekatISA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.User;
import projekatISA.domeinDTO.UserEditPasswordDTO;
import projekatISA.domeinDTO.UserLogDTO;
import projekatISA.domeinDTO.UserRegDTO;
import projekatISA.repository.RepositoryUser;
import projekatISA.serviceInterface.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface{

	@Autowired
	private RepositoryUser repositoryUser;
	
	@Override
	public User findUser(String email, String password) {
		
		User user = repositoryUser.findByEmailEqualsAndPasswordEquals(email, password);
		if(!(user==null)) {
			if(user.isActive()) {
				return user;
			}
		}
		return null;
	}
	
	

	@Override
	public User saveUser(UserRegDTO u) {
		
		if(u.getPassword1().equals(u.getPassword2())) {
			User user = new User();
			user.setEmail(u.getEmail());
			user.setName(u.getName());
			user.setSurname(u.getSurname());
			user.setPassword(u.getPassword1());
			user.setCity(u.getCity());
			user.setPhoneNumber(u.getPhoneNumber());
			
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
	public User findUserEdit(UserRegDTO u) {
		User user = repositoryUser.findByEmailEquals(u.getEmail());
		if(!(user==null)) {
			user.setEmail(u.getEmail());	
			user.setName(u.getName());
			user.setSurname(u.getSurname());
			user.setCity(u.getCity());
			user.setPhoneNumber(u.getPhoneNumber());
			repositoryUser.save(user);
			return user; // da li treba da proveravam jel aktivan ako odma posle regist ulazi na profil
		}
		
		return null;
	}



	@Override
	public User findUserPassword(UserEditPasswordDTO u) {
		
		User user = repositoryUser.findByEmailEquals(u.getEmail());
		
		if(user==null) {
			return null;
		}
		
		if(user.getPassword().equals(u.getCurrentPassword())) {		
			if(u.getNewPassword().equals(u.getRepeatPassword())) {			
				user.setPassword(u.getNewPassword());
				repositoryUser.save(user);				
				return user;
			}			
		}
		
				
		return null;
	}
	
	
}
