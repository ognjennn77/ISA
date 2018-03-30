package projekatISA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.ThematicProps;
import projekatISA.service.ThematicPropsService;

@RestController
@RequestMapping(value="/thematicProps")
public class ThematicPropsController {

	@Autowired
	private ThematicPropsService thematicPropsService; 
	
	
	@RequestMapping(value="/addThematicP",method=RequestMethod.PUT)
	public ResponseEntity<ThematicProps> addThematicP(@RequestBody ThematicProps tp){
		System.out.println("aaaaaaaaaaaaa " + tp.getCinemaTheatre().isCinema());
		ThematicProps thematicProps =thematicPropsService.addThematicProps(tp);
		if(!(thematicProps==null)) {
			return new ResponseEntity<>(thematicProps,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@RequestMapping(value="/getAllThematicP",method=RequestMethod.GET)
	public ResponseEntity<List<ThematicProps>> getAllThematicP(){
		
		List<ThematicProps> thematicProps = thematicPropsService.getAll();
		if(!(thematicProps==null)) {
			return new ResponseEntity<>(thematicProps,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
	}
	
	
	
}
