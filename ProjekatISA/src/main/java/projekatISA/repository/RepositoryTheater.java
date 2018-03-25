package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.Theater;

@Repository
public interface RepositoryTheater extends JpaRepository<Theater,Long>  {

	Theater findOneById(Long id);

	
	
}
