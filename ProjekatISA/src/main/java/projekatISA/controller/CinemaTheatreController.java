package projekatISA.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.CinemaTheatre;
import projekatISA.domein.Repertory;
import projekatISA.domeinDTO.CinemaTheatreDTO;
import projekatISA.service.CinemaTheatreService;
import projekatISA.service.RepertoryService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/cinematheatre")
public class CinemaTheatreController {
	
	@Autowired
	private CinemaTheatreService cinemaTheatreService;
	
	@Autowired
	private RepertoryService repertoryService;
	
	
	@RequestMapping(value="/addCinemaTheatre", method=RequestMethod.PUT)
	public ResponseEntity<CinemaTheatre> addCinemaTheatre(@RequestBody CinemaTheatre ct){
		
		CinemaTheatre cinemaTheatre = cinemaTheatreService.add(ct);
		if(!(cinemaTheatre==null)){
			return new ResponseEntity<>(cinemaTheatre,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<CinemaTheatre> getCinemaTheatre(@PathVariable Long id){
		
		CinemaTheatre cinemaTheatre = cinemaTheatreService.findOne(id);
		if(cinemaTheatre==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cinemaTheatre,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public ResponseEntity<List<CinemaTheatre>> getAll(){
		
		List<CinemaTheatre> cinemaTheatre = cinemaTheatreService.findAll();	
		if(cinemaTheatre==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cinemaTheatre,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/getCinema/{id}", method=RequestMethod.GET)
	public ResponseEntity<CinemaTheatre> getCinema(@PathVariable Long id){
		
		CinemaTheatre cinema = cinemaTheatreService.findCinema(id);
		
		if(!(cinema==null)) {
			return new ResponseEntity<>(cinema,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/getTheatre/{id}",method=RequestMethod.GET)
	public ResponseEntity<CinemaTheatre> getTheatre(@PathVariable Long id){
		
		CinemaTheatre theatre = cinemaTheatreService.findTheatre(id);
		if(!(theatre==null)) {
			return new ResponseEntity<>(theatre,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

	@RequestMapping(value="/getCinemas",method=RequestMethod.GET)
	public ResponseEntity<List<CinemaTheatre>> getCinemas(){
		
		List<CinemaTheatre> cinemas = cinemaTheatreService.findAllCinemas();
		if(!(cinemas==null)) {
			return new ResponseEntity<>(cinemas,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/getTheatres",method=RequestMethod.GET)
	public ResponseEntity<List<CinemaTheatre>> getTheatres(){
		
		List<CinemaTheatre> theatres = cinemaTheatreService.findAllTheatres();
		if(!(theatres==null)) {
			return new ResponseEntity<>(theatres,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(value="/getRepertory/{id}",method=RequestMethod.GET)
	public ResponseEntity<Repertory> getRepertory(@PathVariable Long id){
		
		CinemaTheatre cinemaTheatre = cinemaTheatreService.findOne(id);
		if(cinemaTheatre==null) {
			System.out.println("Ne postoji bioskop sa tim id");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Repertory repertory = repertoryService.findOne(cinemaTheatre.getRepertory().getId());
		if(repertory==null) {
			System.out.println("Ne postoji repository");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(repertory,HttpStatus.OK);
	}
	
}
