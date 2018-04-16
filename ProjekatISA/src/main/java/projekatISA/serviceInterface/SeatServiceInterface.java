package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.ProjectionTerm;
import projekatISA.domein.Seat;

public interface SeatServiceInterface {

	Seat findOne(Long id);
	
	List<Seat> getAll();
	
	Seat add(Seat seat);
	
}
