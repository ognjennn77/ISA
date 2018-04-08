package projekatISA.controller;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.Past;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.Projection;
import projekatISA.domein.Repertory;
import projekatISA.service.RepertoryService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/repertory")
public class RepertoryContoller {

	
	@Autowired
	private RepertoryService repertoryService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Repertory> getRepertory(@PathVariable Long id){
		Repertory repertory = repertoryService.findOne(id);
		if(repertory==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(repertory,HttpStatus.OK);
	}
	
	@RequestMapping(value="/addRepertory",method=RequestMethod.PUT)
	public ResponseEntity<Repertory> addRepertory(@RequestBody Repertory repertory){
		Repertory r = repertoryService.add(repertory);
		if(!(r==null))
			return new ResponseEntity<>(r,HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	
	
	@RequestMapping(value="/addProjection/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Projection> addProjection(@PathVariable Long id, @RequestBody Projection projection){
		
		Projection projection1 = repertoryService.insertProjection(id, projection);
		if(projection1==null)		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(projection1,HttpStatus.OK);
		
	}
	
	
	
}
