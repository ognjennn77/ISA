package projekatISA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.Announcement;
import projekatISA.domein.Bid;
import projekatISA.domein.Notification;
import projekatISA.domein.User;
import projekatISA.repository.RepositoryAnnouncement;
import projekatISA.repository.RepositoryBid;
import projekatISA.repository.RepositoryNotification;
import projekatISA.repository.RepositoryUser;
import projekatISA.serviceInterface.NotificationServiceInterface;

@Service
public class NotificationService implements NotificationServiceInterface{

	@Autowired
	private RepositoryNotification repositoryNotification;
	
	@Autowired
	private RepositoryAnnouncement repositoryAnnouncement;
	
	@Autowired
	private RepositoryBid repositoryBid;
	
	@Autowired
	private RepositoryUser repositoryUser;
	
	@Override
	public Notification newnotification(Notification noti) {
		
		return repositoryNotification.save(noti);
	}

	@Override
	public List<Notification> getNotiOfUser(Long id) {
		
		List<Notification> listNoti = repositoryNotification.findByUsertwo_idEquals(id);
		return listNoti;
	}
	
	/**
	 * Salje obavestenja onima cija ponuda nije prihvacena
	 * @param an je id od onog oglasa na kome se nalaze ponude
	 * @param bid je id od one ponude koja je prihvacena
	 * @param id je id od usera koji sale obavestejne
	 */
	@Override
	public List<Notification> notAcceptB(Long an, Long bid,Long id) {
		
		Announcement announcement = repositoryAnnouncement.findByIdEquals(an);
		List<Bid> listBids = repositoryBid.findByAnnouncement_idEquals(an);
		User user = repositoryUser.findByIdEquals(id);
		
		List<Notification> noti = new ArrayList<>();
		
		for(int i = 0; i<listBids.size();i++) {
			if(!(listBids.get(i).getId().equals(bid))) {	
				Notification notification = new Notification();
				notification.setDescription("Your offer on announcement '" + announcement.getName() + "' not accepted!");
				notification.setUserone(user);
				notification.setUsertwo(listBids.get(i).getUser());
				notification.setType("Accept bid");
				noti.add(notification);
				repositoryNotification.save(notification);
			}
			listBids.get(i).setAccept(true);
			repositoryBid.save(listBids.get(i));
		}
		
		return noti;
	}
	
}
