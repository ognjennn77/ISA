package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.ProjectionDate;

@Repository
public interface RepositoryProjectionDate extends JpaRepository<ProjectionDate, Long>{
	
	
	ProjectionDate findOneById(Long id);

}
