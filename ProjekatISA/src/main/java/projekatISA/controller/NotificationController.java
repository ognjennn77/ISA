package projekatISA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.Notification;
import projekatISA.service.NotificationService;

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
	
	
	
}
