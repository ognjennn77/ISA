package projekatISA.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import projekatISA.service.ProjectionService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
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
	
	@RequestMapping(value="/addProjection",method=RequestMethod.PUT)
	public ResponseEntity<Projection> addProjection(@RequestBody Projection projection){
		
		Projection projection1 = projectionService.add(projection);
		if(projection1==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(projection1,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Projection> getProjection(@PathVariable Long id){
		System.out.println("dosao sam");
		//datum
		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();

		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		

		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

		
		String todayAsString = dateFormat.format(today);
		String tomorrowAsString = dateFormat.format(tomorrow);

		System.out.println(todayAsString);
		System.out.println(tomorrowAsString);
		//
		
		Projection projection = projectionService.findOne(id);
		System.out.println(projection.getProjectionDates().size());
		if(projection==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(projection,HttpStatus.OK);
	}

}
