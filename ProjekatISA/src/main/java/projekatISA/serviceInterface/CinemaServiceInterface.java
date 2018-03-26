package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.Cinema;

public interface CinemaServiceInterface {

	
	Cinema findOne(Long id);
	
	List<Cinema> findAll();
}
