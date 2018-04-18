<<<<<<< HEAD
package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.Reservation;
import projekatISA.domein.Seat;

@Repository
public interface RepositoryReservation extends JpaRepository<Reservation, Long>{

	Reservation findOneById(Long id);
	
}
=======
package projekatISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatISA.domein.Reservation;
import projekatISA.domein.Seat;

@Repository
public interface RepositoryReservation extends JpaRepository<Reservation, Long>{

	Reservation findOneById(Long id);
	
}
>>>>>>> b7e34c37224d5459336e7c8b2af26ddaba99b213
