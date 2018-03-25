package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.Theater;

public interface TheaterServiceInterface {

	Theater findOne(Long id);
	
	List<Theater> findAll();
	
}
