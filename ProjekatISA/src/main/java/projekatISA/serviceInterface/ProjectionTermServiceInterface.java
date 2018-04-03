package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.ProjectionTerm;


public interface ProjectionTermServiceInterface {

	ProjectionTerm findOne(Long id);
	
	List<ProjectionTerm> getAll();
	
	ProjectionTerm add(ProjectionTerm projectionTerm);
	
	
}
