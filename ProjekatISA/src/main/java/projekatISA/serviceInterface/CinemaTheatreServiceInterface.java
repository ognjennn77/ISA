package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.CinemaTheatre;
import projekatISA.domeinDTO.CinemaTheatreDTO;

public interface CinemaTheatreServiceInterface {

	
	CinemaTheatre findOne(Long id);
	
	List<CinemaTheatre> findAll();
	
	CinemaTheatre findCinema(Long id);
	
	CinemaTheatre findTheatre(Long id);
	
	List<CinemaTheatre> findAllCinemas();
	
	List<CinemaTheatre> findAllTheatres();
}
