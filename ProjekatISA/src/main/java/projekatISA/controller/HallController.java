package projekatISA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.Hall;
import projekatISA.domein.ProjectionTerm;
import projekatISA.service.HallService;

@RestController
@RequestMapping(value="/hall")
public class HallController {
	
	
	@Autowired
	private HallService hallService;
	
	@RequestMapping(value="/getAllHalls",method=RequestMethod.GET)
	public ResponseEntity<List<Hall>> getAllHalls(){
		
		List<Hall> halls = hallService.getAll();
		if(halls==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(halls,HttpStatus.OK);
	}
	
	@RequestMapping(value="/addHall",method=RequestMethod.POST)
	public ResponseEntity<Hall> addHall(@RequestBody Hall hall){
	
		Hall hall1 = hallService.add(hall);		
		if(hall1==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(hall1,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Hall> getHall(@PathVariable Long id){
		
		Hall hall = hallService.findOne(id);
		if(hall==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(hall,HttpStatus.OK);
	}

}
