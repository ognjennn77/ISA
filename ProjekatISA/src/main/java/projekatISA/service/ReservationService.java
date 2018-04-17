package projekatISA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.Reservation;
import projekatISA.domein.Seat;
import projekatISA.repository.RepositoryReservation;
import projekatISA.repository.RepositorySeat;
import projekatISA.serviceInterface.ReservationServiceInterface;

@Service
public class ReservationService implements ReservationServiceInterface{

	@Autowired
	private RepositoryReservation repositoryReservation;
	
	@Override
	public Reservation findOne(Long id) {
		Reservation reservation = repositoryReservation.findOneById(id);
		return reservation;
	}

	@Override
	public List<Reservation> getAll() {
		List<Reservation> reservation = repositoryReservation.findAll();
		return reservation;
	}

	@Override
	public Reservation add(Reservation reservation) {
		System.out.println("eeeee");
		return repositoryReservation.save(reservation);
	}

}
