package projekatISA.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projekatISA.domein.CinemaTheatre;
import projekatISA.domeinDTO.CinemaTheatreDTO;
import projekatISA.repository.RepositoryCinemaTheatre;
import projekatISA.serviceInterface.CinemaTheatreServiceInterface;

@Transactional
@Service
public class CinemaTheatreService implements CinemaTheatreServiceInterface{
	
	@Autowired
	private RepositoryCinemaTheatre repositoryCinemaTheatre;

	@Override
	public CinemaTheatre findOne(Long id) {
		CinemaTheatre cinemaTheatre = repositoryCinemaTheatre.findOneById(id);
		return cinemaTheatre;
	}

	@Override
	public List<CinemaTheatre> findAll() {
		List<CinemaTheatre> cinemaTheatre = repositoryCinemaTheatre.findAll();
		/**
		List<CinemaTheatreDTO> listCinemadto = new ArrayList();
		for(CinemaTheatre cinemaT : cinemaTheatre) {
			CinemaTheatreDTO cinemaTheatredto = new CinemaTheatreDTO();
			cinemaTheatredto.setName(cinemaT.getName());
			cinemaTheatredto.setAddress(cinemaT.getAddress());
			cinemaTheatredto.setDescription(cinemaT.getDescription());
			cinemaTheatredto.setRating(cinemaT.getRating());
			cinemaTheatredto.setIscinema(cinemaT.isCinema());
			listCinemadto.add(cinemaTheatredto);
		}
		*/
		return cinemaTheatre;
	}

	@Override
	public CinemaTheatre findCinema(Long id) {
		
		CinemaTheatre cinema = repositoryCinemaTheatre.findOneById(id);
		if(cinema.isCinema()) {
			return cinema;
		}
		return null;
	}

	@Override
	public CinemaTheatre findTheatre(Long id) {
		
		CinemaTheatre theatre = repositoryCinemaTheatre.findOneById(id);
		if(!(theatre.isCinema())) {
			return theatre;
		}
		return null;
	}

	@Override
	public List<CinemaTheatre> findAllCinemas() {
		
		List<CinemaTheatre> cinematheatre = repositoryCinemaTheatre.findAll();
		List<CinemaTheatre> backList = new ArrayList();
		for(CinemaTheatre ct : cinematheatre) {
			if(ct.isCinema()) {
				backList.add(ct);
			}
		}
		return backList;
	}

	@Override
	public List<CinemaTheatre> findAllTheatres() {

		List<CinemaTheatre> cinematheatre = repositoryCinemaTheatre.findAll();
		List<CinemaTheatre> backList = new ArrayList();
		for(CinemaTheatre ct : cinematheatre) {
			if(!(ct.isCinema())) {
				backList.add(ct);
			}
		}
		return backList;		
	
	}

	


}
