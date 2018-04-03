package projekatISA.serviceInterface;

import projekatISA.domein.Announcement;

public interface AnnouncementServiceInterface {

	Announcement addAnn(Announcement an);
	
	Announcement findAnnouncement(Long id);
}
