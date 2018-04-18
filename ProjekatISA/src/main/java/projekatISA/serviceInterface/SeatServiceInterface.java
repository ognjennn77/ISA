<<<<<<< HEAD
package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.ProjectionTerm;
import projekatISA.domein.Seat;
import projekatISA.domein.ThematicProps;

public interface SeatServiceInterface {

	Seat findOne(Long id);
	
	List<Seat> getAll();
	
	Seat add(Seat seat);
	
	List<Seat> getSeats(Long id);
	
	Seat reservingSeat(Long id,Long tp);
	
}
=======
package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.ProjectionTerm;
import projekatISA.domein.Seat;
import projekatISA.domein.ThematicProps;

public interface SeatServiceInterface {

	Seat findOne(Long id);
	
	List<Seat> getAll();
	
	Seat add(Seat seat);
	
	List<Seat> getSeats(Long id);
	
	Seat reservingSeat(Long id,Long tp);
	
}
>>>>>>> b7e34c37224d5459336e7c8b2af26ddaba99b213
