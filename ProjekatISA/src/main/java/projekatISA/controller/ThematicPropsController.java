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

import projekatISA.domein.ThematicProps;
import projekatISA.service.ThematicPropsService;

@RestController
@RequestMapping(value="/thematicProps")
public class ThematicPropsController {

	@Autowired
	private ThematicPropsService thematicPropsService; 
	
	/**
	 * 
	 * Add thematic props in database
	 * @param thematic props
	 * @return
	 */
	@RequestMapping(value="/addThematicP",method=RequestMethod.PUT)
	public ResponseEntity<ThematicProps> addThematicP(@RequestBody ThematicProps tp){
		System.out.println("aaaaaaaaaaaaa " + tp.getCinemaTheatre().isCinema());
		ThematicProps thematicProps =thematicPropsService.addThematicProps(tp);
		if(!(thematicProps==null)) {
			return new ResponseEntity<>(thematicProps,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	/**
	 * Get all thematic props from database
	 * @return List<ThematicProps>
	 */
	@RequestMapping(value="/getAllThematicP",method=RequestMethod.GET)
	public ResponseEntity<List<ThematicProps>> getAllThematicP(){
		
		List<ThematicProps> thematicProps = thematicPropsService.getAll();
		if(!(thematicProps==null)) {
			return new ResponseEntity<>(thematicProps,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
	}
	
	
	@RequestMapping(value="/reserving/{id}",method=RequestMethod.POST)
	public ResponseEntity<ThematicProps> reserving(@PathVariable Long id,@RequestBody ThematicProps tp){
		
		ThematicProps thematicp = thematicPropsService.reservingProps(id,tp);
		
		if(!(thematicp==null)) {
			return new ResponseEntity<>(thematicp,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	
}
