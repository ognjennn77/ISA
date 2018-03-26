package projekatISA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.Theatre;
import projekatISA.service.TheatreService;

@RestController
@RequestMapping(value="/api/theatres")
public class TheatreController {

	@Autowired
	private TheatreService theatreService; 
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Theatre> getTheatre(@PathVariable Long id){
		System.out.println("aaaaa");
		Theatre theatre = theatreService.findOne(id);	
		if(theatre == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(theatre, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/getTheatres", method=RequestMethod.GET)
	public ResponseEntity<List<Theatre>> getTheatres(){
		 List<Theatre> theatres = theatreService.findAll();
		 return new ResponseEntity<>(theatres,HttpStatus.OK); 
	}
	
}
