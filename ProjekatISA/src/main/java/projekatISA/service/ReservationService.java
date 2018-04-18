
package projekatISA.service;

import java.util.ArrayList;
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
		System.out.println(reservation.getUser1().getId());
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

	@Override
	public List<Reservation> getReservation(Long id) {
		List<Reservation> reservation = repositoryReservation.findAll();
		List<Reservation> newres=new ArrayList<Reservation>();
		
		for(int i=0; i<reservation.size();i++) {
			if(reservation.get(i).getUser1().getId().equals(id)) {
				newres.add(reservation.get(i));
			}
			
		}
		return newres;
	}

	

}

