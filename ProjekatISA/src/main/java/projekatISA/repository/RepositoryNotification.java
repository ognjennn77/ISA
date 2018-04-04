package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.Notification;

@Repository
public interface RepositoryNotification extends JpaRepository<Notification, Long>{

}
