<<<<<<< HEAD
package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.Reservation;
import projekatISA.domein.Seat;

public interface ReservationServiceInterface {

	
	Reservation findOne(Long id);
	
	List<Reservation> getAll();
	
	Reservation add(Reservation reservation);
}
=======
package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.Reservation;
import projekatISA.domein.Seat;

public interface ReservationServiceInterface {

	
	Reservation findOne(Long id);
	
	List<Reservation> getAll();
	
	Reservation add(Reservation reservation);
}
>>>>>>> b7e34c37224d5459336e7c8b2af26ddaba99b213
