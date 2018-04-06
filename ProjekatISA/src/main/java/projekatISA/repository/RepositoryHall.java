package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.Hall;
import projekatISA.domein.ProjectionTerm;

@Repository
public interface RepositoryHall extends JpaRepository<Hall, Long>{

	
	Hall findOneById(Long id);
}
