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
import projekatISA.domein.Bid;
import projekatISA.service.AnnouncementService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/announcement")
public class AnnouncementController {

	@Autowired
	private AnnouncementService announcementService; 
	
	/**
	 * Add new announcement in data base
	 * @param an announcement
	 * @return Announcement
	 */
	@RequestMapping(value="/addAnnouncement",method=RequestMethod.PUT)
	public ResponseEntity<Announcement> addAnnouncement(@RequestBody Announcement an){

		Announcement announcement = announcementService.addAnn(an);
		
		if(!(announcement==null)) {
			return new ResponseEntity<>(announcement,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	
	/**
	 * Get the announcement of the id
	 * @param id of the announcement
	 * @return Announcement
	 */
	@RequestMapping(value="/getAnnouncement/{id}", method=RequestMethod.GET)
	public ResponseEntity<Announcement> getAnnouncement(@PathVariable Long id){
		
		Announcement an = announcementService.findAnnouncement(id);
		
		if(!(an==null)) {
			return new ResponseEntity<>(an,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	/**
	 * Get all announcement
	 * @return list of announcement
	 */
	@RequestMapping(value="/getAllAnnouncements/{id}", method=RequestMethod.POST)
	public ResponseEntity<List<Announcement>> getAnnouncements(@PathVariable Long id){
		
		List<Announcement> announcements = announcementService.getAllAnn(id);
		System.out.println(announcements);
		if(!(announcements==null)) {
			return new ResponseEntity<>(announcements,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	
	/**
	 * Get bids of the announcement
	 * @param id of announcement
	 * @return List of bids
	 */
	@RequestMapping(value="/getBidOfAnnouncement/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<Bid>> getBidOfAnnouncement(@PathVariable Long id){
		
		List<Bid> bids = announcementService.findBids(id);
		
		if(!(bids==null)) {
			return new ResponseEntity<>(bids,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	/**
	 * Get announcements of user
	 * @param id of user
	 * @return
	 */
	@RequestMapping(value="/getAnnauncementsOfUser/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<Announcement>> getAnnauncementsOfUser(@PathVariable Long id){
		
			List<Announcement> retunrList = announcementService.getAnnOfUser(id);
			
			if(!(retunrList==null)) {
				return new ResponseEntity<>(retunrList,HttpStatus.OK);
			}
		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	
	
	
}
