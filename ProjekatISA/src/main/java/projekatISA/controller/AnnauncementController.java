package projekatISA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.Annauncement;
import projekatISA.service.AnnauncementService;

@RestController
@RequestMapping(value="/annauncement")
public class AnnauncementController {

	@Autowired
	private AnnauncementService annauncementService; 
	
	
	@RequestMapping(value="/addAnnauncement",method=RequestMethod.PUT)
	public ResponseEntity<Annauncement> addAnnauncement(@RequestBody Annauncement an){
	
		Annauncement annauncement = annauncementService.addAnn(an);
		
		if(!(annauncement==null)) {
			return new ResponseEntity<>(annauncement,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	
	
	@RequestMapping(value="/getAnnauncement/{id}", method=RequestMethod.GET)
	public ResponseEntity<Annauncement> getAnnauncement(@PathVariable Long id){
		
		Annauncement an = annauncementService.findAnnauncement(id);
		
		if(!(an==null)) {
			return new ResponseEntity<>(an,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
}
