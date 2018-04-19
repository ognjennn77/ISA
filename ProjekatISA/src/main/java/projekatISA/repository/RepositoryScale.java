package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.Scale;



@Repository
public interface RepositoryScale extends JpaRepository<Scale, Long> {

	Scale findByIdEquals(Long id);
	
}
