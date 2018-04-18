
package projekatISA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.Reservation;
import projekatISA.domein.Seat;
import projekatISA.domein.ThematicProps;
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

	@Override
	public Reservation deleteReser(Long id) {
		Reservation reser = repositoryReservation.findOneById(id);
		System.out.println("datum"+reser.getProjectionterm().getTerm());
		if(reser.getSeats().size()!=0) {
			for(int i=0; i<reser.getSeats().size();i++) {
				reser.getSeats().get(i).setReserved(false);
			}
		}
		if(!(reser==null)) {
			repositoryReservation.delete(reser);
			return reser;
		}
		return null;
	}

	

}

