package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.ProjectionTerm;
import projekatISA.domein.Seat;

@Repository
public interface RepositorySeat extends JpaRepository<Seat, Long>{

	Seat findOneById(Long id);
	
}
