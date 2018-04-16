package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.ProjectionTerm;
import projekatISA.domein.Seat;
import projekatISA.domein.ThematicProps;

public interface SeatServiceInterface {

	Seat findOne(Long id);
	
	List<Seat> getAll();
	
	Seat add(Seat seat);
	
	Seat reservingSeat(Long id,Long tp);
	
}
