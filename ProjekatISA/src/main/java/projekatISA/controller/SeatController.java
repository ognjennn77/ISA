
package projekatISA.controller;

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

import projekatISA.domein.ProjectionDate;
import projekatISA.domein.Seat;
import projekatISA.domein.ThematicProps;
import projekatISA.service.SeatService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/seat")
public class SeatController {
	
	@Autowired
	private SeatService seatService;

	@RequestMapping(value="/getAllSeats",method=RequestMethod.GET)
	public ResponseEntity<List<Seat>> getAllProjectionDates(){
		
		List<Seat> seats = seatService.getAll();
		if(seats==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(seats,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/addSeat",method=RequestMethod.POST)
	public ResponseEntity<Seat> addProjectionDate(@RequestBody Seat seat){
		
		
		
		Seat seat1 = seatService.add(seat);
		if(seat1==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(seat1,HttpStatus.OK);		
	}
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Seat> getProjection(@PathVariable Long id){
		
		Seat seat = seatService.findOne(id);
		if(seat==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(seat,HttpStatus.OK);
	}
	
	//posaljes termin, on ti izlista sedista
	@RequestMapping(value="/getSeats/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<Seat>> getSeats(@PathVariable Long id){
		
		List<Seat> seats = seatService.getSeats(id);
		if(seats==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(seats,HttpStatus.OK);
	}
	
	@RequestMapping(value="/reserving/{id}/{tp}",method=RequestMethod.POST)
	public ResponseEntity<Seat> reserving(@PathVariable Long id,@PathVariable Long tp){
		
		Seat seat = seatService.reservingSeat(id,tp);
		
		if(!(seat==null)) {
			return new ResponseEntity<>(seat,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
}


