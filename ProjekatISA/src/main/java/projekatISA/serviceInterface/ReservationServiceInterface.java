
package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.Reservation;
import projekatISA.domein.Seat;
import projekatISA.domein.ThematicProps;

public interface ReservationServiceInterface {

	
	Reservation findOne(Long id);
	
	List<Reservation> getAll();
	
	Reservation add(Reservation reservation);
	
	List<Reservation> getReservation(Long id);
	
	List<Reservation> getHistoryRes(Long id);
	
	Reservation deleteReser(Long id);
}
