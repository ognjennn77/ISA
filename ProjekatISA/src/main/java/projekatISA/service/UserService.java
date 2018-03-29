package projekatISA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.User;
import projekatISA.domeinDTO.UserDTO;
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
		else {
			System.out.println("ne postoji korisnik sa ti email i pass");
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
			
			User user1 = repositoryUser.findByEmailEquals(user.getEmail());
			if(user1==null) {
				System.out.println("Sacuvan je novi korisnik");
				return repositoryUser.save(user);
			}	
			System.out.println("Korisnik sa tim email-om vec postoji");
		}
		System.out.println("Nisu unete iste lozinke");
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
		else
			System.out.println("ne postoji user sa tim email");
		return null;
	}



	@Override
	public User findUserPassword(UserDTO u) {
		
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
			else {
				System.out.println("nisu isti passwordi");
			}
		}
		else {
			System.out.println("password iz baze i trenutni pass nisu isti");
		}
		
				
		return null;
	}
	
	
}
