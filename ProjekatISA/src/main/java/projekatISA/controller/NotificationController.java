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

import projekatISA.domein.Notification;
import projekatISA.service.NotificationService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/notification")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;
	
	/**
	 * Create new notification for the user
	 * @param notification
	 * @return notification
	 */
	@RequestMapping(value="/newNotification", method=RequestMethod.PUT)
	public ResponseEntity<Notification> newNotification(@RequestBody Notification noti){

		Notification notification = notificationService.newnotification(noti);
		
		if(!(notification==null)){
			return new ResponseEntity<>(notification,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		
		
	}
	
	
	/**
	 * get all notification of user
	 * @param id of user
	 * @return List notification
	 */
	@RequestMapping(value="/getNotificationOfUser/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<Notification>> getNotificationOfUser(@PathVariable Long id){
		
		List<Notification> returnList = notificationService.getNotiOfUser(id);
		
		if(!(returnList==null)) {
			return new ResponseEntity<>(returnList,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Salje obavestenja onima cija ponuda nije prihvacena
	 * @param an je id od onog oglasa na kome se nalaze ponude
	 * @param bid je id od one ponude koja je prihvacena
	 * @param id je id od usera koji sale obavestejne
	 * @return
	 */
	@RequestMapping(value="/notAcceptBid/{id}/{an}/{bid}", method=RequestMethod.GET)
	public ResponseEntity<List<Notification>> notAcceptBid(@PathVariable Long an, @PathVariable Long bid, @PathVariable Long id){
			
		
		List<Notification> returnList = notificationService.notAcceptB(an,bid,id);
		
		if(!(returnList==null)) {
			return new ResponseEntity<>(returnList,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
}
