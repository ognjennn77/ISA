package projekatISA.service;

import java.util.ArrayList;
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
		System.out.println("bbbbbb"+seat.getProjectiont().get(0).getId());
		System.out.println("bbbbbb"+seat.getProjectiont().get(1).getId());
		System.out.println("bbbbbb"+seat.getProjectiont().get(2).getId());
		return seat;
	}

	@Override
	public List<Seat> getAll() {
		List<Seat> seats = repositorySeat.findAll();
		System.out.println("bbbbbb"+seats.get(0).getProjectiont().get(0).getId());
		return seats;
	}

	@Override
	public Seat add(Seat seat) {
		return repositorySeat.save(seat);
	}

	@Override
	public List<Seat> getSeats(Long id) {
		System.out.println("id od zadatog termina"+id);
		List<Seat> seats = repositorySeat.findAll();
		List<Seat> newseats=new ArrayList<Seat>();
		System.out.println("broj sedista"+seats.size());
		System.out.println("broj sedista"+newseats.size());
		
		for(int i=0; i<seats.size();i++) {
			//System.out.println("smaras"+seats.get(i).getProjectiont().size());
			if(seats.get(i).getProjectiont()!=null) {
				for(int j=0; j<seats.get(i).getProjectiont().size();j++) {
					System.out.println("broj termina vezanih za sediste"+seats.get(i).getProjectiont().size());
					if(seats.get(i).getProjectiont().get(j).getId().equals(id)) {
						System.out.println("id od termina iz fora"+seats.get(i).getProjectiont().get(j).getId());
						newseats.add(seats.get(i));
					}
				}
			}
		}
		System.out.println("kraj"+newseats.size());
		return newseats;
	}

}
