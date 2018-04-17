package projekatISA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.Notification;
import projekatISA.repository.RepositoryNotification;
import projekatISA.serviceInterface.NotificationServiceInterface;

@Service
public class NotificationService implements NotificationServiceInterface{

	@Autowired
	private RepositoryNotification repositoryNotification;

	@Override
	public Notification newnotification(Notification noti) {
		
		return repositoryNotification.save(noti);
	}

	@Override
	public List<Notification> getNotiOfUser(Long id) {
		
		List<Notification> listNoti = repositoryNotification.findByUsertwo_idEquals(id);
		return listNoti;
	}
	
}
