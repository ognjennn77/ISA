package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.Announcement;

@Repository
public interface RepositoryAnnouncement extends JpaRepository<Announcement, Long>{

	Announcement findByIdEquals(Long id);
}
