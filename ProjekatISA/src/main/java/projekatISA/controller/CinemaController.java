package projekatISA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.Cinema;
import projekatISA.service.CinemaService;

@RestController
public class CinemaController {
	
	@Autowired
	private CinemaService cinemaService;
	
	
	public ResponseEntity<Cinema> getCinema(@PathVariable Long id){
		Cinema cinema = cinemaService.findOneCinema(id);
		if(cinema==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cinema,HttpStatus.OK);		
	}
	
	
	
	

}
