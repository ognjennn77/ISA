package projekatISA.controller;

import java.text.ParseException;
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
import projekatISA.domein.User;
import projekatISA.service.ThematicPropsService;

@RestController
@RequestMapping(value="/thematicProps")
public class ThematicPropsController {

	@Autowired
	private ThematicPropsService thematicPropsService; 
	
	/**
	 * 
	 * Administrator add thematic props in database
	 * @param thematic props
	 * @return
	 */
	@RequestMapping(value="/addThematicP",method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<ThematicProps> addThematicP(@RequestBody ThematicProps tp){

		ThematicProps thematicProps =thematicPropsService.addThematicProps(tp);
		if(!(thematicProps==null)) {
			return new ResponseEntity<>(thematicProps,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	/**
	 * Get one thematic props from data base
	 * @param id
	 * @return thematic props
	 */
	@RequestMapping(value="/getThematicP/{id}", method=RequestMethod.GET)
	public ResponseEntity<ThematicProps> getThematicP(@PathVariable Long id){
		
		ThematicProps thematicP = thematicPropsService.findOneProps(id);
	
		if(!(thematicP==null)) {
			return new ResponseEntity<>(thematicP,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
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
	
	/**
	 * The user reserving the props
	 * @param id of the user
	 * @param tp(thematic props)
	 * @return thematic props
	 */
	@RequestMapping(value="/reserving/{id}",method=RequestMethod.POST)
	public ResponseEntity<ThematicProps> reserving(@PathVariable Long id,@RequestBody ThematicProps tp){
		
		ThematicProps thematicp = thematicPropsService.reservingProps(id,tp);
		
		if(!(thematicp==null)) {
			return new ResponseEntity<>(thematicp,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	/**
	 * Administrator editing props
	 * @param tp
	 * @return thematic props
	 */
	@RequestMapping(value="/editProps",method=RequestMethod.POST)
	public ResponseEntity<ThematicProps> editProps(@RequestBody ThematicProps tp){
		
		ThematicProps thematicp = thematicPropsService.editProps(tp);
		
		if(!(thematicp==null)) {
			return new ResponseEntity<>(thematicp,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	/**
	 * Get the user of the thematic props
	 * @param id of thematic props
	 * @return User 
	 */
	@RequestMapping(value="/getUserOfProps/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> getUserOfProps(@PathVariable Long id) throws ParseException{
		
		User user = thematicPropsService.findUserOfProps(id);

		if(!(user==null)) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(value="/removeProps/{id}", method=RequestMethod.POST)
	public ResponseEntity<ThematicProps> removeProps(@PathVariable Long id){
		
		ThematicProps tp = thematicPropsService.deleteProps(id);
		
		if(!(tp==null)) {
			return new ResponseEntity<>(tp,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	
}
