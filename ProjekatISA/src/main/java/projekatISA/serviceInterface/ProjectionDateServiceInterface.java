package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.ProjectionDate;

public interface ProjectionDateServiceInterface {
	
	ProjectionDate findOne(Long id);
	
	List<ProjectionDate> getAll();
	
	ProjectionDate add(ProjectionDate projectionDate);

}
