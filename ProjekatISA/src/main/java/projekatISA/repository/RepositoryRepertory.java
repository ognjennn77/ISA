package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.Repertory;

@Repository
public interface RepositoryRepertory extends JpaRepository<Repertory, Long>{

	Repertory findOneById(Long id);
	
}
