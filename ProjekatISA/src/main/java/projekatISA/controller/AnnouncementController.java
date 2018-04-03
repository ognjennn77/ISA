package projekatISA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.Announcement;
import projekatISA.service.AnnouncementService;

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
	
	
}