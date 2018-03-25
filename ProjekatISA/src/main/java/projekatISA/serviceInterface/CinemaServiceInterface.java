package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.Cinema;

public interface CinemaServiceInterface {

	
	Cinema findOneCinema(Long id);
	
	List<Cinema> findAll();
}
