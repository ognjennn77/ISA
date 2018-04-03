package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.ProjectionDate;
import projekatISA.domein.ProjectionTerm;

@Repository
public interface RepositoryProjectionTerm extends JpaRepository<ProjectionTerm, Long>{

	
	ProjectionTerm findOneById(Long id);
	
}
