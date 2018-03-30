package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.Projection;

public interface ProjectionServiceInterface {
	
	Projection findOne(Long id);
	
	List<Projection> getAll();

}
