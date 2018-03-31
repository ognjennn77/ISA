package projekatISA.serviceInterface;

import projekatISA.domein.Projection;
import projekatISA.domein.Repertory;

public interface RepertoryServiceInterface {

	
	Repertory findOne(Long id);
	
	Repertory add(Repertory repertory);
	
	Projection insertProjection(Long id, Projection projection);
}
