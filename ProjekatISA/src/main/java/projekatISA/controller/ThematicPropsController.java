package projekatISA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.ThematicProps;
import projekatISA.service.ThematicPropsService;

@RestController
@RequestMapping(value="api/thematicProps")
public class ThematicPropsController {

	@Autowired
	private ThematicPropsService thematicPropsService; 
	
	
	@RequestMapping(value="addThematicP")
	public ResponseEntity<ThematicProps> addThematicP(@RequestBody ThematicProps tp){
		
		ThematicProps thematicProps =thematicPropsService.addThematicProps(tp);
		if(!(thematicProps==null)) {
			return new ResponseEntity<>(thematicProps,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	
	
}
