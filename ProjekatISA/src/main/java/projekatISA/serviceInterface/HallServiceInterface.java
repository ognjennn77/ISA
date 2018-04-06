package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.Hall;


public interface HallServiceInterface {

	Hall findOne(Long id);
	
	List<Hall> getAll();
	
	Hall add(Hall projectionTerm);
	
}
