package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.Announcement;
import projekatISA.domein.Bid;

public interface AnnouncementServiceInterface {

	Announcement addAnn(Announcement an);
	
	Announcement findAnnouncement(Long id);
	
	List<Bid> findBids(Long id);
	
	List<Announcement> getAllAnn(Long id);
	
	List<Announcement> getAnnOfUser(Long id);
	
	Announcement getAnnouncementOnAdmin(Long id, Long an);
	
	Announcement approveAnn(Long an);
}
