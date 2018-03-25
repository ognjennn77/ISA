package projekatISA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import projekatISA.domein.Theater;
import projekatISA.repository.RepositoryTheater;
import projekatISA.serviceInterface.TheaterServiceInterface;


@Service
public class TheaterService implements TheaterServiceInterface{

	
	@Autowired
	private RepositoryTheater repositoryTheater;
	
	
	@Override
	public Theater findOne(Long id) {
		return repositoryTheater.findOneById(id);
	}

	@Override
	public List<Theater> findAll() {
		return repositoryTheater.findAll();
	}

	
	
}
