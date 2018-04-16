package projekatISA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.ProjectionDate;
import projekatISA.domein.Seat;
import projekatISA.domein.ThematicProps;
import projekatISA.domein.User;
import projekatISA.repository.RepositorySeat;
import projekatISA.repository.RepositoryUser;
import projekatISA.serviceInterface.SeatServiceInterface;

@Service
public class SeatService implements SeatServiceInterface{

	@Autowired
	private RepositorySeat repositorySeat;
	
	@Autowired
	private RepositoryUser repositoryUser;
	
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
	public Seat reservingSeat(Long id, Long tp) {
		User user = repositoryUser.findByIdEquals(id);
		if(!(user==null)) {
			Seat seat = repositorySeat.findOneById(tp);
			seat.setReserved(true);
			seat.setUser(user);
			repositorySeat.save(seat);
			return seat;
		}
		return null;
	}

}
