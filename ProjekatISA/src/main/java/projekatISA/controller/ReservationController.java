<<<<<<< HEAD
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

import projekatISA.domein.Reservation;
import projekatISA.domein.Seat;
import projekatISA.service.ReservationService;
import projekatISA.service.SeatService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/reservation")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(value="/getAllReservations",method=RequestMethod.GET)
	public ResponseEntity<List<Reservation>> getAllProjectionDates(){
		
		List<Reservation> reservation = reservationService.getAll();
		if(reservation==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(reservation,HttpStatus.OK);
	}
	
	@RequestMapping(value="/addReservation",method=RequestMethod.PUT)
	public ResponseEntity<Reservation> addProjectionDate(@RequestBody Reservation reservation){
		
		System.out.println("stigao");
		
		Reservation reservation1 = reservationService.add(reservation);
		System.out.println("i ovde stigao");
		if(reservation1==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(reservation1,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Reservation> getProjection(@PathVariable Long id){
		
		Reservation reservation = reservationService.findOne(id);
		if(reservation==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(reservation,HttpStatus.OK);
	}

}
=======
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

import projekatISA.domein.Reservation;
import projekatISA.domein.Seat;
import projekatISA.service.ReservationService;
import projekatISA.service.SeatService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/reservation")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(value="/getAllReservations",method=RequestMethod.GET)
	public ResponseEntity<List<Reservation>> getAllProjectionDates(){
		
		List<Reservation> reservation = reservationService.getAll();
		if(reservation==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(reservation,HttpStatus.OK);
	}
	
	@RequestMapping(value="/addReservation",method=RequestMethod.PUT)
	public ResponseEntity<Reservation> addProjectionDate(@RequestBody Reservation reservation){
		
		System.out.println("stigao");
		
		Reservation reservation1 = reservationService.add(reservation);
		System.out.println("i ovde stigao");
		if(reservation1==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(reservation1,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Reservation> getProjection(@PathVariable Long id){
		
		Reservation reservation = reservationService.findOne(id);
		if(reservation==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(reservation,HttpStatus.OK);
	}

}
>>>>>>> b7e34c37224d5459336e7c8b2af26ddaba99b213
