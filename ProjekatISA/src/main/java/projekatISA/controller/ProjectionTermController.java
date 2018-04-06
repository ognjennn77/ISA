package projekatISA.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.ProjectionDate;
import projekatISA.domein.ProjectionTerm;
import projekatISA.service.ProjectionTermService;


@RestController
@RequestMapping(value="/projectionterm")
public class ProjectionTermController {

	
	@Autowired
	private ProjectionTermService projectionTermService;
	
	@RequestMapping(value="/getAllProjectionTerms",method=RequestMethod.GET)
	public ResponseEntity<List<ProjectionTerm>> getAllProjectionTerms(){
		
		List<ProjectionTerm> projectionTerms = projectionTermService.getAll();
		if(projectionTerms==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(projectionTerms,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/addProjectionTerm",method=RequestMethod.POST)
	public ResponseEntity<ProjectionTerm> addProjectionTerm(@RequestBody ProjectionTerm projectionTerm){

		
		ProjectionTerm projectionterm1 = projectionTermService.add(projectionTerm);
		
		
		
		if(projectionterm1==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(projectionterm1,HttpStatus.OK);		
	}
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<ProjectionTerm> getProjectionTerm(@PathVariable Long id){
		
		ProjectionTerm projectionterm = projectionTermService.findOne(id);
		if(projectionterm==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(projectionterm,HttpStatus.OK);
	}
	
	
}
