package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.Theatre;

@Repository
public interface RepositoryTheater extends JpaRepository<Theatre,Long>  {

	Theatre findOneById(Long id);

	
	
}
