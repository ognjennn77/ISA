package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.Reservation;
import projekatISA.domein.Seat;

public interface ReservationServiceInterface {

	
	Reservation findOne(Long id);
	
	List<Reservation> getAll();
	
	Reservation add(Reservation reservation);
}
