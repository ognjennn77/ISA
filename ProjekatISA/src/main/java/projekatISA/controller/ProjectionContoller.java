package projekatISA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.Projection;
import projekatISA.service.ProjectionService;

@RestController
@RequestMapping(value="/projection")
public class ProjectionContoller {
	
	@Autowired
	private ProjectionService projectionService;
	
	@RequestMapping(value="/getAllProjections",method=RequestMethod.GET)
	public ResponseEntity<List<Projection>> getAllProjectons(){
		
		List<Projection> projections = projectionService.getAll();
		if(!(projections==null)) {
			return new ResponseEntity<>(projections, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}

}
