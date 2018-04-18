package projekatISA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.Notification;

@Repository
public interface RepositoryNotification extends JpaRepository<Notification, Long>{
	
	
	List<Notification> findByUsertwo_idEquals(Long id);
	
	List<Notification> findByTypeEquals(String s);
}
