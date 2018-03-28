package projekatISA.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.Cinema;
import projekatISA.domeinDTO.CinemaInfoDTO;
import projekatISA.service.CinemaService;

@RestController
@RequestMapping(value="/api/cinemas")
public class CinemaController {
	
	@Autowired
	private CinemaService cinemaService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Cinema> getCinema(@PathVariable Long id){
		Cinema cinema = cinemaService.findOne(id);
		if(cinema==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cinema,HttpStatus.OK);		
	}
	
	@RequestMapping(value="getCinemas",method=RequestMethod.GET)
	public ResponseEntity<List<CinemaInfoDTO>> getCinemas(){
		
		List<Cinema> cinemas = cinemaService.findAll();
		
		List<CinemaInfoDTO> listCinemadto = new ArrayList();
		for(Cinema cinema : cinemas) {
			CinemaInfoDTO cinemadto = new CinemaInfoDTO();
			cinemadto.setName(cinema.getName());
			cinemadto.setAddress(cinema.getAddress());
			cinemadto.setDescription(cinema.getDescription());
			cinemadto.setRating(cinema.getRating());
			listCinemadto.add(cinemadto);
		}
		return new ResponseEntity<>(listCinemadto,HttpStatus.OK);		
	}

}
