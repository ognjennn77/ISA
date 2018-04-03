package projekatISA.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import projekatISA.domein.Projection;
import projekatISA.domein.ProjectionDate;
import projekatISA.service.ProjectionDateService;
import projekatISA.service.ProjectionService;

@RestController
@RequestMapping(value="/projectiondate")
public class ProjectionDateContoller {
	
	@Autowired
	private ProjectionDateService projectionDateService;
	
	@RequestMapping(value="/getAllProjectionDates",method=RequestMethod.GET)
	public ResponseEntity<List<ProjectionDate>> getAllProjectionDates(){
		
		List<ProjectionDate> projectionDates = projectionDateService.getAll();
		if(projectionDates==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(projectionDates,HttpStatus.OK);
	}
	
	@RequestMapping(value="/addProjectionDate",method=RequestMethod.PUT)
	public ResponseEntity<ProjectionDate> addProjectionDate(@RequestBody ProjectionDate projectionDate){
		
		System.out.println(projectionDate.getDate()+"date");
		System.out.println(projectionDate.getTime()+"time");
		
		ProjectionDate projectiondate1 = projectionDateService.add(projectionDate);
		if(projectiondate1==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(projectiondate1,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<ProjectionDate> getProjection(@PathVariable Long id){
		
		ProjectionDate projectiondate = projectionDateService.findOne(id);
		if(projectiondate==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(projectiondate,HttpStatus.OK);
	}
	

}
