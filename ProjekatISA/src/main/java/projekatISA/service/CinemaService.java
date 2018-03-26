package projekatISA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekatISA.domein.Cinema;
import projekatISA.repository.RepositoryCinema;
import projekatISA.serviceInterface.CinemaServiceInterface;

@Transactional
@Service
public class CinemaService implements CinemaServiceInterface{
	
	@Autowired
	private RepositoryCinema repositoryCinema;

	@Override
	public Cinema findOne(Long id) {
		Cinema cinema = repositoryCinema.findOneById(id);
		return cinema;
	}

	@Override
	public List<Cinema> findAll() {
		List<Cinema> cinemas = repositoryCinema.findAll();
		return cinemas;
	}
	
	

}
