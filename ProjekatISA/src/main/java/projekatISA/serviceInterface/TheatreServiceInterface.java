package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.Theatre;

public interface TheatreServiceInterface {

	Theatre findOne(Long id);
	
	List<Theatre> findAll();
	
}
