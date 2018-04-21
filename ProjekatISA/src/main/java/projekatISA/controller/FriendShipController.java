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

import projekatISA.domein.Announcement;
import projekatISA.domein.FriendShip;
import projekatISA.domein.User;
import projekatISA.service.FriendShipeService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/friendship")
public class FriendShipController {

	@Autowired
	private FriendShipeService friendShipeService;
	
	/**
	 * send friendship
	 * @param idone - id korisnika koji salje zahtev
	 * @param idtwo - id korisnika kome se salje zahtev
	 * @return friendship
	 */
	@RequestMapping(value="/addFriendShip/{idone}/{idtwo}",method=RequestMethod.POST)
	public ResponseEntity<FriendShip> addFriendShip(@PathVariable Long idone, @PathVariable Long idtwo){

		FriendShip friendship = friendShipeService.addfriendship(idone,idtwo);
		
		if(!(friendship==null)) {
			return new ResponseEntity<>(friendship,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	
	/**
	 * Get friend request
	 * @param idone - vracamo zahteve za prijateljsto od ovog user koji ima ovaj id
	 * @return
	 */
	@RequestMapping(value="/getFriendRequest/{idtwo}",method=RequestMethod.GET)
	public ResponseEntity<List<FriendShip>> addFriendShip(@PathVariable Long idtwo){

		List<FriendShip> friendship = friendShipeService.getfriendrequest(idtwo);
		
		if(!(friendship==null)) {
			return new ResponseEntity<>(friendship,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	
	/**
	 * accept friend request
	 * @param idf - id of friend request
	 * @return
	 */
	@RequestMapping(value="/acceptRequest/{idf}",method=RequestMethod.POST)
	public ResponseEntity<FriendShip> acceptRequest(@PathVariable Long idf){

		FriendShip friendship = friendShipeService.acceptrequest(idf);
		
		if(!(friendship==null)) {
			return new ResponseEntity<>(friendship,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	
	
	/**
	 * decline friend request
	 * @param idf - id of friend request
	 * @return
	 */
	@RequestMapping(value="/declineRequest/{idf}",method=RequestMethod.POST)
	public ResponseEntity<FriendShip> declineRequest(@PathVariable Long idf){

		FriendShip friendship = friendShipeService.declinerequest(idf);
		
		if(!(friendship==null)) {
			return new ResponseEntity<>(friendship,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	
	/**
	 * 
	 * @param idone - id od koga vracam prijatelje
	 * @return
	 */
	@RequestMapping(value="/getFriend/{idone}",method=RequestMethod.GET)
	public ResponseEntity<List<User>> getFriend(@PathVariable Long idone){

		List<User> friends = friendShipeService.getfriends(idone);
		
		if(!(friends==null)) {
			return new ResponseEntity<>(friends,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	
}
