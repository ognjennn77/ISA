package projekatISA.serviceInterface;

import projekatISA.domein.Repertory;

public interface RepertoryServiceInterface {

	
	Repertory findOne(Long id);
	
	Repertory add(Repertory repertory);
}
