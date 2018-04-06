package projekatISA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.Hall;
import projekatISA.domein.ProjectionTerm;
import projekatISA.repository.RepositoryHall;
import projekatISA.repository.RepositoryProjectionTerm;
import projekatISA.serviceInterface.HallServiceInterface;

@Service
public class HallService implements HallServiceInterface{

	@Autowired
	private RepositoryHall repositoryHall;
	
	@Override
	public Hall findOne(Long id) {
		Hall hall = repositoryHall.findOneById(id);
		return hall;
	}

	@Override
	public List<Hall> getAll() {
		List<Hall> halls = repositoryHall.findAll();
		return halls;
	}

	@Override
	public Hall add(Hall hall) {
		return repositoryHall.save(hall);
	}

}
