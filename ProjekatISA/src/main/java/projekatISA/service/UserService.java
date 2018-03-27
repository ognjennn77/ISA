package projekatISA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.User;
import projekatISA.repository.RepositoryUser;
import projekatISA.serviceInterface.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface{

	@Autowired
	private RepositoryUser repositoryUser;
	
	@Override
	public User findUser(String email, String password) {
		User user = repositoryUser.findByEmailEqualsAndPasswordEquals(email, password);
		return user;
	}

	@Override
	public User saveUser(User u) {
		User user = repositoryUser.findByEmailEqualsAndPasswordEquals(u.getEmail(), u.getPassword());
		if(user==null) {
			return repositoryUser.save(u);
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

	

	
	
}
