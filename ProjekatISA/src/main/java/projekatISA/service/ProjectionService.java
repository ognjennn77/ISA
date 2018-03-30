package projekatISA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.Projection;
import projekatISA.repository.RepositoryProjection;
import projekatISA.serviceInterface.ProjectionServiceInterface;

@Service
public class ProjectionService implements ProjectionServiceInterface{

	@Autowired
	private RepositoryProjection repositoryProjection;
		
	@Override
	public Projection findOne(Long id) {
		Projection projection = repositoryProjection.findOneById(id);
		return projection;
	}

	@Override
	public List<Projection> getAll() {
		List<Projection> projections = repositoryProjection.findAll();
		return projections;
	}

}
