package projekatISA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.ProjectionDate;
import projekatISA.repository.RepositoryProjectionDate;
import projekatISA.serviceInterface.ProjectionDateServiceInterface;

@Service
public class ProjectionDateService implements ProjectionDateServiceInterface{

	@Autowired
	private RepositoryProjectionDate repositoryProjectionDate;
	
	@Override
	public ProjectionDate findOne(Long id) {
		ProjectionDate projectionDate = repositoryProjectionDate.findOneById(id);
		return projectionDate;
	}

	@Override
	public List<ProjectionDate> getAll() {
		List<ProjectionDate> projectionDates = repositoryProjectionDate.findAll();
		return projectionDates;
	}

	@Override
	public ProjectionDate add(ProjectionDate projectionDate) {
		
		return repositoryProjectionDate.save(projectionDate);
	}
	
	

}
