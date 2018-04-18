
package projekatISA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.ProjectionDate;
import projekatISA.domein.Seat;
import projekatISA.domein.ThematicProps;
import projekatISA.domein.User;
import projekatISA.repository.RepositorySeat;
import projekatISA.serviceInterface.SeatServiceInterface;

@Service
public class SeatService implements SeatServiceInterface{

	@Autowired
	private RepositorySeat repositorySeat;
	
	@Override
	public Seat findOne(Long id) {
		Seat seat = repositorySeat.findOneById(id);
		
		return seat;
	}

	@Override
	public List<Seat> getAll() {
		List<Seat> seats = repositorySeat.findAll();
		
		return seats;
	}

	@Override
	public Seat add(Seat seat) {
		return repositorySeat.save(seat);
	}

	@Override
	public List<Seat> getSeats(Long id) {
		
		List<Seat> seats = repositorySeat.findAll();
		List<Seat> newseats=new ArrayList<Seat>();
		
		
		for(int i=0; i<seats.size();i++) {
			
			if(seats.get(i).getProjectiont()!=null) {
				for(int j=0; j<seats.get(i).getProjectiont().size();j++) {
					
					if(seats.get(i).getProjectiont().get(j).getId().equals(id)) {
						
						newseats.add(seats.get(i));
					}
				}
			}
		}
		
		return newseats;
	}

	@Override
	public Seat reservingSeat(Long id, Long tp) {
		
		
		Seat seat = repositorySeat.findOneById(tp);
		if(seat!=null) {
			seat.setReserved(true);
			System.out.println("sediste rezervisano");
			repositorySeat.save(seat);
			return seat;
		}
		return null;
	}

}
