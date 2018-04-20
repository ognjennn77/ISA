package projekatISA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.Announcement;
import projekatISA.domein.Scale;
import projekatISA.service.ScaleService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/scaleprople")
public class ScalePeopleController {

	@Autowired
	private ScaleService scaleService;
	
	@RequestMapping(value="/addscaleprople",method=RequestMethod.PUT)
	public ResponseEntity<Scale> addAnnouncement(@RequestBody Scale s){

		Scale scale = scaleService.addscale(s);
		
		if(!(scale==null)) {
			return new ResponseEntity<>(scale,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
}
