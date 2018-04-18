
package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.Reservation;
import projekatISA.domein.Seat;

@Repository
public interface RepositoryReservation extends JpaRepository<Reservation, Long>{

	Reservation findOneById(Long id);
	
}

