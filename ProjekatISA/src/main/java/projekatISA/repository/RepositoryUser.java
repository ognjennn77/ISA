package projekatISA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.User;

@Repository
public interface RepositoryUser extends JpaRepository<User, Long>{
	
	
	User findByEmailEqualsAndPasswordEquals(String email, String password);

	User findByEmailEquals(String email);
	
	User findByIdEquals(Long id);
	
	List<User> findByAdminfanzoneEquals(boolean s);
}
