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
		
		List<Notification> returnList = new ArrayList<>();
		
		for(int i=0; i<listNoti.size();i++) {
			if(listNoti.get(i).getType().equals("Accept bid")) {
				returnList.add(listNoti.get(i));
			}
		}
		
		return returnList;
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

	//prvi if da vratim samo ona obavestenja za koja je admin zaduzen a ne da
	//vracam i neka druga obavestenja(npr. da ne vrati obavestenje za prihvatanje ponude)
	
	//drugi if vracam samo ona obavestenja koja jos niko nije preuzeo na sebe
	@Override
	public List<Notification> getAnnouncementForAdmin(Long id) {
		
		List<Notification> notiList = repositoryNotification.findByTypeEquals("Approve announcement");
		
		List<Notification> returnList = new ArrayList<>();
		
		for(int i = 0; i< notiList.size();i++) {
			if(notiList.get(i).getUsertwo().getId().equals(id)) {
				User admin = notiList.get(i).getAnnouncement().getAdmin();
				if(admin==null || admin.getId().equals(id)) {
					returnList.add(notiList.get(i));
				}
				
			}
			
		}
		return returnList;
		
	}
	
}
