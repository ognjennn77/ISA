package projekatISA.controller;

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
import projekatISA.domein.Bid;
import projekatISA.service.BidService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/bid")
public class BidController {

	@Autowired
	private BidService bidService;
	
	
	/**
	 * Add the bid on the announcement
	 * @param bid
	 * @return bid
	 */
	@RequestMapping(value="/addBidOnAnnouncement", method=RequestMethod.PUT)
	public ResponseEntity<Bid> addBid(@RequestBody Bid bid){
		
		Bid b = bidService.addbid(bid);
		if(!(b==null)) {
			return new ResponseEntity<>(b,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	/**
	 * Get the bid
	 * @param id of the bid
	 * @return Bid
	 */
	@RequestMapping(value="/getBid/{id}", method=RequestMethod.GET)
	public ResponseEntity<Bid> getBid(@PathVariable Long id){
		
		Bid b = bidService.getbid(id);
		System.out.println();
		if(!(b==null)) {
			return new ResponseEntity<>(b,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	/**
	 * Get the announcement of the bid
	 * @param id od the bid
	 * @return Announcement
	 */
	@RequestMapping(value="/getAnnoncementOfBid/{id}", method=RequestMethod.GET)
	public ResponseEntity<Announcement> getAnnoncementOfBid(@PathVariable Long id){

		Announcement announcement = bidService.findAnnouncementOfBid(id);
		
		if(!(announcement==null)) {
			return new ResponseEntity<>(announcement,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
	} 


	
	
}
