package projekatISA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.ProjectionDate;
import projekatISA.domein.Seat;
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

}
