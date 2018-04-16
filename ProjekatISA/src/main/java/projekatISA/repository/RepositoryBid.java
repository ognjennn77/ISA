package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.Bid;

@Repository
public interface RepositoryBid extends JpaRepository<Bid, Long>{

	
	Bid findByIdEquals(Long id);
	
	
	Bid findByUser_idEqualsAndAnnouncement_idEquals(Long id,Long an);
	
	
	
}
