package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.Notification;

public interface NotificationServiceInterface {

	Notification newnotification(Notification noti);
	
	List<Notification> getNotiOfUser(Long id);
	List<Notification> notAcceptB(Long an, Long bid,Long id);
}
