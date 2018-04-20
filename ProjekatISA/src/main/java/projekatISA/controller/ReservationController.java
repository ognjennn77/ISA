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
import projekatISA.domein.ThematicProps;
import projekatISA.domein.User;
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
	
	//vraca rez od usera koje tek slede
	@RequestMapping(value="/getReservations/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<Reservation>> getProjectionDates(@PathVariable Long id){
		System.out.println("brt onooo");
		List<Reservation> reservation = reservationService.getReservation(id);
		
		if(reservation==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(reservation,HttpStatus.OK);
	}
	
	//vraca rez od usera na koje je isao
	@RequestMapping(value="/getHistory/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<Reservation>> getHistoryReser(@PathVariable Long id){
		
		List<Reservation> reservation = reservationService.getHistoryRes(id);
		
		if(reservation==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(reservation,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/removeReser/{id}", method=RequestMethod.POST)
	public ResponseEntity<Reservation> removeProps(@PathVariable Long id){
		
		Reservation r = reservationService.deleteReser(id);
		
		if(!(r==null)) {
			return new ResponseEntity<>(r,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	
	@RequestMapping(value="/inviteFriends/{id}/{td}", method=RequestMethod.POST)
	public ResponseEntity<Reservation> inviteFRI(@PathVariable Long id,@PathVariable Long td){
		System.out.println("e brt onoo");
		Reservation r = reservationService.inviteFri(id,td);
		
		if(!(r==null)) {
			return new ResponseEntity<>(r,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	
	@RequestMapping(value="/NOOOacceptInvite/{id}")
	public String acceptingRegistration(@PathVariable Long id) {
		Reservation reser1 = reservationService.acceptInvite(id);
		if(!(reser1==null)) {
			return "success";
		}
		return "unsuccess";
	}
	
	@RequestMapping(value="/sendEmailReservation/{id}/{td}", method=RequestMethod.POST)
	public ResponseEntity<Reservation> sendEmailRes(@PathVariable Long id,@PathVariable Long td){
		
		Reservation r = reservationService.sendEmailReser(id,td);
		
		if(!(r==null)) {
			return new ResponseEntity<>(r,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	
	

}

