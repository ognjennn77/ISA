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
import projekatISA.repository.RepositoryNotification;
import projekatISA.repository.RepositoryUser;
import projekatISA.serviceInterface.AnnouncementServiceInterface;

@Service
public class AnnouncementService implements AnnouncementServiceInterface{

	
	@Autowired 
	private RepositoryAnnouncement repositoryAnnouncement;
	
	@Autowired
	private RepositoryNotification repositoryNotification;
	
	@Autowired
	private RepositoryUser repositoryUser;
	
	/**
	 * Dodavanje oglasa i slanje oglasa svim administratorima na proveru
	 */
	@Override
	public Announcement addAnn(Announcement an) {
		
		repositoryAnnouncement.save(an);
		
		List<User> adminiFanZone = repositoryUser.findByAdminfanzoneEquals(true);
		
		for(int i = 0; i<adminiFanZone.size();i++) {
			
			Notification notification = new Notification();
			notification.setUserone(an.getUser());
			notification.setType("Approve announcement");
			notification.setUsertwo(adminiFanZone.get(i));
			notification.setAnnouncement(an);
			notification.setDescription("Checking announcement '" + an.getName() + "'!" );
			repositoryNotification.save(notification);
		}
		return an;
	}

	@Override
	public Announcement findAnnouncement(Long id) {
		Announcement an = repositoryAnnouncement.findByIdEquals(id);
		System.out.println(an.getDate());
		if(!(an==null)) {
			return an;
		}
		return null;
	}

	@Override
	public List<Bid> findBids(Long id) {
		
		Announcement an = repositoryAnnouncement.findByIdEquals(id);
		if(!(an==null)) {
			List<Bid> b = an.getBids();
			
			if(!(b==null)) {
				return b;
			}
		}
		return null;
	}

	/**
	 * Pomocu prvog if-a vracam samo one announcement koji nisu od ulogovanog usera
	 * Pomocu drugog if-a vracam samo one annoucement koji su odobreni od strane administratora
	 */
	@Override
	public List<Announcement> getAllAnn(Long id) {
		List<Announcement> returnList = repositoryAnnouncement.findAll();
		List<Announcement> listAnnouncement = new ArrayList<>();
		if(!(returnList==null)) {
			for(int i = 0; i<returnList.size();i++) {
				if(!(returnList.get(i).getUser().getId().equals(id))) {
					if(returnList.get(i).isApproved()) {
						listAnnouncement.add(returnList.get(i));
					}
				}
			}
			
			return listAnnouncement;
		}
		return null;
	}

	@Override
	public List<Announcement> getAnnOfUser(Long id) {
		List<Announcement> announcements = repositoryAnnouncement.findByUser_idEquals(id);
		List<Announcement> returnList = new ArrayList<>();
		
		for(int i = 0;i<announcements.size();i++) {
			if(announcements.get(i).isApproved()) {
				returnList.add(announcements.get(i));
			}
		}
		return returnList;
	}

	@Override
	public Announcement getAnnouncementOnAdmin(Long id, Long an) {
		
		User user = repositoryUser.findByIdEquals(id);
		
		if(!(user==null)) {
			Announcement announcement = repositoryAnnouncement.findByIdEquals(an);
		
			if(!(announcement==null)) {
				announcement.setAdmin(user);
				repositoryAnnouncement.save(announcement);
				return announcement;
			}
		}
		
		return null;
	}

	@Override
	public Announcement approveAnn(Long an) {
		
		Announcement announcement = repositoryAnnouncement.findByIdEquals(an);
	
		if(!(announcement==null)) {
			announcement.setApproved(true);
			repositoryAnnouncement.save(announcement);
		}
		return null;
	}
	
}
