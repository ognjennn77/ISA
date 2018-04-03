package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.Annauncement;

@Repository
public interface RepositoryAnnauncement extends JpaRepository<Annauncement, Long>{

	Annauncement findByIdEquals(Long id);
}
