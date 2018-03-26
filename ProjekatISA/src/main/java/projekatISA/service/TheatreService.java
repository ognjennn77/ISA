package projekatISA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import projekatISA.domein.Theatre;
import projekatISA.repository.RepositoryTheater;
import projekatISA.serviceInterface.TheatreServiceInterface;


@Service
public class TheatreService implements TheatreServiceInterface{

	
	@Autowired
	private RepositoryTheater repositoryTheater;
	
	
	@Override
	public Theatre findOne(Long id) {
		return repositoryTheater.findOneById(id);
	}

	@Override
	public List<Theatre> findAll() {
		return repositoryTheater.findAll();
	}

	
	
}
